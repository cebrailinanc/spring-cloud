package com.cbrl.spring.cloud.domain.user.service.impl;

import com.cbrl.spring.cloud.domain.user.data.dao.impl.UserDaoImpl;
import com.cbrl.spring.cloud.domain.user.data.model.User;
import com.cbrl.spring.cloud.domain.user.dto.UserDto;
import com.cbrl.spring.cloud.domain.user.dto.UserDto;
import com.cbrl.spring.cloud.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDao;

    @Override
    public Optional<UserDto> getUser(Long id) {
        Optional<User> user = userDao.findById(id);
        Optional<UserDto> userDto = user.map(user1 -> UserDto.builder().firstName(user1.getFirstName())
                .email(user1.getEmail()).build());
        return userDto;
    }
}
