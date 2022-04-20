
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
        // 내장 WAS(Web Application Server) 실행

    }
}
