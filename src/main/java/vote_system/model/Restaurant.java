package vote_system.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank()
    private String name;

    public Restaurant() {    }

    public Restaurant(Integer id, String name) {

        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                '}';
    }
}
