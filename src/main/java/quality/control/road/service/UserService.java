package quality.control.road.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quality.control.road.model.User;
import quality.control.road.model.init_data.UserData;
import quality.control.road.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    public final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findByUsername(username);
        User user = UserData.user;
        logger.info("Найден такой user" + user);
        if (user!=null) return user;
        else throw new UsernameNotFoundException("Пользователь " + username + " не был найден!");
    }
}
