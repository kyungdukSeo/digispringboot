package com.kbstar.springboot.study.domain.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role
{
    // ADMIN, USER, GUEST
    // ROLE..

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "회원");

    private final String key;
    private final String title;


}

/*
    ENUM : ENUMerate, tElephone NUMber

    Trying = 100,
    OK = 200,
    AuthError=401, Forbidden = 403, NotFound, MethodNotAllowed          --> notfound 자동으로 404, 405 ..

    SUN=1, MON, TUE, WED, THU, FRI, SAT

    열거형
    자바에서는 ENUM 잘 사용하지않고, INTERFACE를 활용함

 */