package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImpl(UserRepository uRepository) {
        this.repository = uRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser =  repository.findByUsername(username);

        UserDetails user = new org.springframework.security.core.userdetails.User(username,
        currentUser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(currentUser.getRole()));

    return user;
    }
}
