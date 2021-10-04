package com.example.shoppingonline.service.jwt;


import com.example.shoppingonline.DTO.ShoppingUsersDetail;
import com.example.shoppingonline.entity.Users;
import com.example.shoppingonline.repository.IUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements JwtUserDetailService {


    private final IUsersRepository usersRepositoryl;

    public JwtUserDetailServiceImpl(IUsersRepository usersRepositoryl) {
        this.usersRepositoryl = usersRepositoryl;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users usersByAccount = usersRepositoryl.findUsersByAccount(s);
        if (usersByAccount == null) {
            throw new UsernameNotFoundException("User " + s + " not found");
        }
        return new ShoppingUsersDetail(usersByAccount);
    }
    int i = 1; //test
}
