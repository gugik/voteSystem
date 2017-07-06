package vote_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vote_system.model.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
