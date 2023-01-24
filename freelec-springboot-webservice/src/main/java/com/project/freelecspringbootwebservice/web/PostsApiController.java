package com.project.freelecspringbootwebservice.web;

import com.project.freelecspringbootwebservice.service.posts.PostsService;
import com.project.freelecspringbootwebservice.web.dto.PostSaveRequestDto;
import com.project.freelecspringbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    // Controller, Service 모두 Autowired 사용 권장하지 않음
    //생성자 주입방식을 권장하므로 final로 선언하고 RequireArgsConstructor 어노테이션으로 Bean객체를 받도록 함
    private final PostsService postsService;

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
}
