package vote_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vote_system.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

}