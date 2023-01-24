package com.project.freelecspringbootwebservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        // JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드 지정
        // 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
        // 여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행시 테스트가 실패할 수 있음
        postsRepository.deleteAll();
    }

    @Test
    public void save_content(){
        String title = "제목";
        String content = "본문";

        // save : insert/update 실행
            // id 값이 있다면 update 실행, 없다면 insert 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("dh@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_post(){
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate: "+posts.getCreateDate()+", modifiedDate: "+posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now); //now보다 posts의 createdDate가 미래라면 true 리턴
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}
