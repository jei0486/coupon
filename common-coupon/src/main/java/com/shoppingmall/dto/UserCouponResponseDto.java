package com.shoppingmall.dto;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Builder
public class UserCouponResponseDto {

    private String user_id;
    private String c_name;
    private Integer discount;
    private String start_dt;
    private String end_dt;
    private char rate_yn;
    private String issued_at;
    private String used_at;
    private String use_yn;

}
