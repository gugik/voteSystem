package vote_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vote_system.TO.VoteTO;
import vote_system.model.Vote;


import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT new vote_system.TO.VoteTO (v.restaurant.name, count(v)) FROM Vote v WHERE v.date=:date GROUP BY v.restaurant.name")
    List<VoteTO> getTotal(@Param("date") LocalDate date);

    Vote findByUserIdAndDate(Integer userId, LocalDate date);

}
