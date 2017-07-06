package vote_system.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Dish extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank()
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull()
    private Integer price;

    public Dish() {
    }

    public Dish(String name, Integer price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
