package com.kbstar.springboot.study.domain.posts;

import com.fasterxml.jackson.annotation.JsonTypeId;
// import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.kbstar.springboot.study.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

/*
    13. 게시글 관련 클래스 정의
    <form method='post' enctype='multipart/form-data' action='a.jpg'>
        <input type='file' name='upfile'>
    </form>

    @Entity : JPA 에서 필요한 Annotation
        테이블과 클래스를 매핑해준다.
        Posts.java  ->  posts 데이터베이스 테이블 매핑
            myFamilyCount   (Camel 표기법)
            my_family_count (Snake 표기법, Linux 이름짓는 방식) -> JPA 에선 사용하지 않는걸 추천

    @Id : 데이터베이스의 키 값
    @GeneratedValue : 키 생성
    @Column : 데이터베이스 테이블을 내부적으로 생성해줄 때 사이즈 등을 설정

    ==> 할일 : 저장소를 위한 PostsRepository 생성해야 한다
              class : PostsRepository.java
 */
/*
    31 : JPA Auditing를 위해서 BaseTimeEntity클래스를 상속받는다.

    Application.java 시작하는 부분에
        JPA Auditing 어노테이션 활성화 시키는 어노테이션 추가
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;


    // 복제생성자, Copy Constructor
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
        24. 데이터 지속성(Consistent : 객체와 Entity의 일치)
            객체가 업데이트 되면 자동으로 DB데이터가 변경

            실제 DB에 업데이트 되도록 만들기
            DTO가  ---->    Service 만들기
     */

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

}

