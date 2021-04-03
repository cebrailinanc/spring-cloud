package com.cbrl.spring.cloud.base;

import com.cbrl.spring.cloud.base.model.BaseDto;
import com.cbrl.spring.cloud.base.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public abstract class BaseController<T> {
    @Autowired
    protected T service;

    protected ApiResponse run(Optional<? extends BaseDto> baseDto) {
        return ApiResponse.success(baseDto.orElse(null));
    }
}
