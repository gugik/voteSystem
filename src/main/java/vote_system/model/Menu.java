package vote_system.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "menu")

public class Menu extends BaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull()
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    protected List<Dish> dishes;

    public Menu() {
    }

    public Menu(LocalDate date, Restaurant restaurant) {
        this.date = date;
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "date=" + date +
                ", restaurant=" + restaurant +
                ", dishes=" + dishes +
                '}';
    }
}
