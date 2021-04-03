package com.cbrl.spring.cloud.base.config;

import com.cbrl.spring.cloud.base.response.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

@RequiredArgsConstructor
@Component
public class ErrorMessageLocator {

    private final ResourceBundleMessageSource messageSource;

    public ApiError error(String key, Object... args) {
        return ApiError.builder()
                .code(messageSource.getMessage(key + ".code", args, Locale.ENGLISH))
                .message(messageSource.getMessage(key + ".message", args, Locale.ENGLISH))
                .build();
    }
}
