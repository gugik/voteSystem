package vote_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vote_system.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String name);

}
