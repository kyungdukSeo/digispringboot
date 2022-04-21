package com.kbstar.springboot.study;
// com.kbstar.study

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Alt + Enter = import (Ctrl + Shift + o)
@SpringBootApplication
// SpringBoot 를 자동 설정
// 여기서부터 설정을 읽는다.
// 항상 프로젝트의 최상단에 위치

public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        // main 에서 시작
        // 내장 WAS(Web com.kbstar.springboot.study.Application Server) 실행

    }
}

// 02. 설정 바꾸기
// File > Settings > Editor > General > Code Completion > Match case 해제 (대소문자 구분 해제) > Apply

// JSP : MVC Model
//      Model, View, Controller

// 10. http://localhost:8080/hello/dto/?name=홍길동&age=78

/*
    11. JPA
    Java Persistence API : 자바 지속성 API
    클래스 <-> DB 자동 Mapping
    기존 방식 : 프로그래밍의 대부분이 Query
    ORM(Object Relation Mapping)
    --> SQL의 종속성에서 벗어나게 하겠다.

    CRUD (Create, Read, Update, Delete)
        조회 : Member member = jpa.find(memberID)
    JPA를 사용할 때의 장점 : 수정이 매우 간단하다(유지보수)
        객체(class)가 변경되면, 알아서 DB에 Update Query 날아간다.

    +--------------------------+
    |  Java Application        |
    |  +--------------------+  |
    |  | JPA                |  |
    |  |  +--------------+  |  |           +----------+
    |  |  |   JDBC API   |- |- |----SQL--->|   DB     |
    |  |  |              |<-|- |---------- |          |
    |  |  +--------------+  |  |           + ---------+
    |  +--------------------+  |
    +-------------------------+

 */