package com.kbstar.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
    16. Annotation 설명
    @AfterEach = @After 최신버전
        각 단위 테스트가 끝날 때 마다 수행해야하는 작업 정의
        테스트가 DB추가 -> 실제 데이터에 영향을 미칠 수 있다.
        in-memory DB : H2DB
        postsRepository.save()
            INSERT / UPDATE 둘 중 하나를 수행
            키 값 없으면 : Insert
            키 값 있으면 : Update
        insert into..
        update mytable set ... where idx='idx'

    postsRepository.findAll()
        SELECT *
        결과를 List Collection 에 add()

    현재 : Test -> Success
        내부적으로 어떤일을 수행하는지 확인 => Query 출력
        => main/resources/application.properties 파일을 만들어서 세팅필요
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest
{
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    // 할일 다 끝나면 @Aftereach 처리해라
    public void cleanup()
    {
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad()
    {
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("user@kbstar.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("--------------------- title = " + posts.getTitle());
        /*
            15. 단축키 설정 sysout
            File > Settings > Keymap > Eclipse 선택

            검색창 : Live Template
                > 왼쪽 Editor > Live Template 선택
                > 오른쪽 Java 하위목록 펼침
                > sout~ 시작되는 항목 블록선택
                > 오른쪽 마우스 change context 클릭
                > java 선택 후 apply
         */

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void baseTimeEntityTest()
    {
        LocalDateTime now = LocalDateTime.of(2022, 4, 25, 0, 0, 0);
        postsRepository.save(Posts.builder().title("kb title").content("kb content").author("user@kbstar.com").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        System.out.println("------------------------------------createDate : " + posts.getCreateDate() + "-------------------------------");
        System.out.println("------------------------------------modifiedDate : " + posts.getModifiedDate() + "-------------------------------");

        assertThat(posts.getTitle()).isEqualTo("kb title");
        assertThat(posts.getContent()).isEqualTo("kb content");
        // 날짜확인
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
