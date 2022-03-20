package com.case5.demo.app.sec.security;


import com.case5.demo.app.user.entity.User;
import com.case5.demo.app.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userEntityService.findByUserName(username);

        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserByUserId(Long id) {

        User user = userEntityService.getByIdWithControl(id);

        return JwtUserDetails.create(user);
    }
}
