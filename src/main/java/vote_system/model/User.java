package vote_system.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.*;


@Entity

@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @SafeHtml
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Length(min = 5)
    //@JsonView(View.JsonREST.class)
    @SafeHtml
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String email, String password, Collection<Role> roles) {
        super(id);
        this.email = email;
        this.password = password;
        setRoles(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", email=" + email +
                ", roles=" + roles +
                '}';
    }
}
