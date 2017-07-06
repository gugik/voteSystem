package vote_system.TO;

import vote_system.model.Dish;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

public class MenuTO implements Serializable {
    private LocalDate date;

    private Integer restaurantId;

    protected List<Dish> dishes;

    public MenuTO() {
    }

    public MenuTO(LocalDate date, Integer restaurantId, List<Dish> dishes) {
        this.date = date;
        this.restaurantId = restaurantId;
        this.dishes = dishes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "MenuTO{" +
                "date=" + date +
                ", restaurant=" + restaurantId +
                ", dishes=" + dishes +
                '}';
    }
}
