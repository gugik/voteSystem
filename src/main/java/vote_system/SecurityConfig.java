package vote_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import vote_system.repository.UserRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Autowired
    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailServiceImpl(userRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
        //http.authorizeRequests().antMatchers("/console").permitAll();
        //http.authorizeRequests().antMatchers("/*", "/console").permitAll();
        //http.authorizeRequests().and().csrf().disable();
    }
}