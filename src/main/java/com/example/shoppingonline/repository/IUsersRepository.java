package com.example.shoppingonline.repository;

import com.example.shoppingonline.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    Users findUsersByAccount(String account);
}
