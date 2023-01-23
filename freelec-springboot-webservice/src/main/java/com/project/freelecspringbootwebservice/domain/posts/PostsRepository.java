package com.project.freelecspringbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { //JpaRepostory<Entity클래스, PK타입> : Dao라고 불리는 DB Layer 접근자
    //CRUD 메소드 자동으로 생성
}
