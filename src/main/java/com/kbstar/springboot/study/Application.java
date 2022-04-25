package com.kbstar.springboot.study;
// com.kbstar.study

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Alt + Enter = import (Ctrl + Shift + o)
@SpringBootApplication
// SpringBoot 를 자동 설정
// 여기서부터 설정을 읽는다.
// 항상 프로젝트의 최상단에 위치
@EnableJpaAuditing
/*
    32. JPA Auditing 을 위한 어노테이션 추가
    @EnableJpaAuditing
    다시 실행시킨 후 h2-console에 들어가서 필드 추가된것 확인
    (원래 단위테스트를 먼저 하는게 순서임)
    단위 테스트
        PostsRepositoryTest에 다시 넣고, 검색하는 기능 확인

    내부적인 동작 : save, update, delete, select 기본적으로 만들어진 상태
        확인을 위해 HTML로 처리..

    기존 방식
        $sql = "select * from posts order by idx desc";
        $result = mysqli_query($conn, $sql);
        $data = mysqli_fetch_array($result);

        while($data)
        {
            // HTML 태그로 출력
            ?>
                <div class='row'>
                    <div class='col'><?php echo $data["title"]?>
                </div>
            <?php
            $data = mysqli_fetch_array($result);
        }

        mustache라는 (마스코트 : 콧수염) 패키지 설치
            매우 간단한 템플릿 엔진 (HTML 템플릿제공??)
            ReAct

        plugins : mustache install
        mustache를 프로그램이 인식할수 있도록 build.gradle 추가(미리 추가해뒀음)

        작업을 위한 디렉토리(폴더)구조
        src/main/resources/templates/index.mustache

 */
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
