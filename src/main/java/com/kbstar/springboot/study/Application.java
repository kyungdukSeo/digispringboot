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
