package com.cbrl.spring.cloud.base.handler;

import com.cbrl.spring.cloud.base.response.ApiResponse;

public interface Handler<T extends Exception> {
    ApiResponse handleException(T exception);
}
