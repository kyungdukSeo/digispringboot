/*
    PostsService.java
    게시판 서비스에 필요한 기능들을 함수로 정의해둔 파일
    Posts 클래스, PostsRepository 인터페이스 에 정의된 DB의 컬럼들을 통해 DB에 직접적인 영향을 주는경우
    @Transactional 어노테이션을 통해 트랜잭션이 처음부터 끝까지 정상적으로 완료되는것을 담보한다.

 */


package com.kbstar.springboot.study.service;


import com.kbstar.springboot.study.domain.posts.Posts;
import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsListResponseDto;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import com.kbstar.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
    19. Service 등록

    자동으로 만들어지는 생성자
    public PostsService(PostsRepository postsRepository)
    {
        this.postsRepository=postsRepository;
    }

    Transaction : All or Nothing (전부다 성공하거나, 전부 실패)

 */

@RequiredArgsConstructor
@Service
public class PostsService
{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("------------------------Post Service---------------------------- title = " + requestDto.getTitle());
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    /*
        25. 업데이트를 위한 매핑(객체랑 DB)

        등록 : /api/v1/posts      <-- 새글 등록
        수정 : /api/v1/posts/3    <-- 3번글을 수정

        1) DTO -> Service -> Controller

     */

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No id for Post findById(id).orElseThrow : " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public int updateView(Long id)
    {
        return postsRepository.updateView(id);
    }

    @Transactional
    public int increaseRecommend(Long id)
    {
        return postsRepository.increaseRecommend(id);
    }


    public Page<Posts> pageList(Pageable pageable)
    {
        return postsRepository.findAll(pageable);       // postsRepository.findAllPage
    }

    public PostsResponseDto findById(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No id for Post findById(id).orElseThrow : " + id));
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)     // select 일때만 readOnly option 사용가능, 성능개선을 위해..
    public List<PostsListResponseDto> findAllDesc()
    {
        return postsRepository
                .findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No id for Post findById(id).orElseThrow : " + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public Page<Posts> search(String keyword, Pageable pageable)
    {
        // List<Posts> postsList = postsRepository.findByTitleContaining(keyword);

        Page<Posts> postsList = postsRepository.findByTitleContaining(keyword, pageable);

        return postsList;
    }


    /*
        람다식 ES6
        .map(PostsListResponseDto::new)
        = .map(posts->new PostsListResponseDto(posts))
     */
}
