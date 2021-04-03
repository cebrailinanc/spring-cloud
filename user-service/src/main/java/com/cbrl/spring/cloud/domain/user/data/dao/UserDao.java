package com.cbrl.spring.cloud.domain.user.data.dao;

import com.cbrl.spring.cloud.domain.user.data.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findById(Long id);
}
