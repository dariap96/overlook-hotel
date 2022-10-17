package itmo.com.overlook.hotel.security.user_details;

import itmo.com.overlook.hotel.entities.User;
import itmo.com.overlook.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.getUserByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));
		return UserDetailsImpl.build(user);
	}

}
