package vote_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vote_system.model.User;
import vote_system.repository.UserRepository;

@Service
class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(name);
        if (u == null) {
            throw new UsernameNotFoundException("User " + name + " is not found");
        }
        return new AuthorizedUser(u);
    }
}