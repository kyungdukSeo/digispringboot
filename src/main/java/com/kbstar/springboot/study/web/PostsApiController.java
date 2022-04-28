
package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.service.PostsService;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import com.kbstar.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/*
    20. 작업 순서

    Controller -------(DTO 주면서 저장요청)--------> Service 저장요청 ---------> DB

    <form method="post" action="/api/v1/posts">
                        <-- action="main.php?cmd=board&mode=insert" -->
        <input type="text" name="title">
        <textarea name="content"></textarea>
        <button type="submit">저장</button>
    </form>

 */

@RequiredArgsConstructor
@RestController
public class PostsApiController
{
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        System.out.println("----------------Controller -> Service");
        return postsService.save(requestDto);
    }

    /*
        26. 수정을 위한 REST 등록
        Method : POST, PUT(0), GET, DELETE

        DTO -> Service -> Controller -> 단위테스트

     */
    @PutMapping("/api/v1/posts/{id}")   // 수정
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }

    @PostMapping("/api/v1/rec/{id}")   // 수정
    public int increaseRecommend(@PathVariable Long id)
    {
        return postsService.increaseRecommend(id);
    }


    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id)
    {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")   // id에 해당하는 글 보여주기
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }


}


