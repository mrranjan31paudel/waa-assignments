package assignment.lab6.service.impl;

import assignment.lab6.domain.dto.UserAuthDetailsDto;
import assignment.lab6.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    final private UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserAuthDetailsDto loadUserByUsername(String username) {
        if(username == null)
            return null;

        return userRepo.findByUsername(username)
                .map(user -> new UserAuthDetailsDto(user))
                .orElse(null);
    }
}
