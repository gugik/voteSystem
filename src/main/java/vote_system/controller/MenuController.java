package vote_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vote_system.model.Menu;
import vote_system.TO.MenuTO;
import vote_system.repository.DishRepository;
import vote_system.repository.MenuRepository;
import vote_system.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;

    private final RestaurantRepository restaurantRepository;

    private final DishRepository dishRepository;

    @Autowired
    public MenuController(RestaurantRepository restaurantRepository, DishRepository dishRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
        this.menuRepository = menuRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody MenuTO menuTO) {
        Menu menu = menuRepository.findByRestaurantIdAndDate(menuTO.getRestaurantId(), menuTO.getDate());
        if (menu!=null) menuRepository.delete(menu);
        menu=new Menu(menuTO.getDate(), restaurantRepository.getOne(menuTO.getRestaurantId()));
        menuTO.getDishes().forEach(dishRepository::save);
        menu.setDishes(menuTO.getDishes());
        menuRepository.save(menu);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        menuRepository.delete(id);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @GetMapping(value = "/one/{id}")
    public Menu getOne(@PathVariable("id") Integer id) {
        return menuRepository.findOne(id);
    }

    @GetMapping(value = "/findByDate/{date}")
    public List<Menu> findByDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date) {
        return menuRepository.findByDate(date);
    }

}
