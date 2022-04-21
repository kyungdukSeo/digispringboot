package com.kbstar.springboot.study.domain.posts;

import lombok.Builder;
import lombok.Generated;
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
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;


    // 복제생성자, Copy Constructor
    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
