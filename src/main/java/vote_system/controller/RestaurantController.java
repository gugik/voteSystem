package vote_system.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vote_system.model.Restaurant;
import vote_system.repository.*;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @PutMapping()
    public void add(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "name") String name) {
        restaurantRepository.save(new Restaurant(id, name));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        restaurantRepository.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    String exceptionHandler() {
        return "The restaurant is needed for history";
    }
}
