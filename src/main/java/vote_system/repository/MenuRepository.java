package vote_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vote_system.model.Menu;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByDate(LocalDate date);

    Menu findByRestaurantIdAndDate(Integer restaurantId, LocalDate date);

}
