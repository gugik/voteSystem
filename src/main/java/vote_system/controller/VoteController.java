package vote_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vote_system.AuthorizedUser;
import vote_system.TO.VoteTO;
import vote_system.model.Vote;
import vote_system.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vote")

public class VoteController {

    private final VoteRepository voteRepository;

    private final RestaurantRepository restaurantRepository;

    private final UserRepository userRepository;

    @Autowired
    public VoteController(VoteRepository voteRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @PutMapping(value = "/{restaurantId}")
    public void vote(@PathVariable("restaurantId") Integer restaurantId) throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();
        int userId = AuthorizedUser.id();
        if (dateTime.getHour() < 11) {
            Vote vote = voteRepository.findByUserIdAndDate(userId, dateTime.toLocalDate());
            if (vote != null) {
                vote.setRestaurant(restaurantRepository.getOne(restaurantId));
                voteRepository.save(vote);
            } else
                voteRepository.save(new Vote(dateTime.toLocalDate(), restaurantRepository.getOne(restaurantId), userRepository.findOne(userId)));
        } else throw new Exception();
    }

    @GetMapping(value = "/resultByDay/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VoteTO> resultByDay(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date) {
        return voteRepository.getTotal(date);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    String exceptionHandler() {
        return "It is too late.";
    }
}
