package com.shoppingmall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotExistCouponException extends RuntimeException {

    public NotExistCouponException(String msg){
        super(msg);
    }
}
