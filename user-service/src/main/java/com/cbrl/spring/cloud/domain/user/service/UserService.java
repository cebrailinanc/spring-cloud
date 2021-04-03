package com.cbrl.spring.cloud.domain.user.service;

import com.cbrl.spring.cloud.domain.user.dto.UserDto;
import java.util.Optional;

public interface UserService {
    Optional<UserDto> getUser(Long id);
}
