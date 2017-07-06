package vote_system.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "date_time", "user_id"})})

public class Vote extends BaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull()
    private LocalDate date;

    @OneToOne()
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Vote() {
    }

    public Vote(LocalDate date, Restaurant restaurant, User user) {
        this.date = date;
        this.restaurant = restaurant;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "date=" + date +
                ", restaurant=" + restaurant +
                ", user=" + user +
                '}';
    }
}
