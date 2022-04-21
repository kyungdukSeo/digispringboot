package com.kbstar.springboot.study.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
/*
    14. 저장소를 위한 interface
    Posts 클래스로부터 DB 접근이 가능하게 해 줄 JpaRepository
    MyBatis : DAO : Data Access Object
              cf. DTO : Data Transfer Object
              
              JpaRepository<클래스, PrimaryKey>
              이녀석을 상속받기만 하면 CRUD 메소드가 자동 생성된다
              
              Entity 클래스 = Posts
              Entity Repository = PostsRepository
              이 둘은 같은 위치에 있어야한다.(같은 package 안에 있어야한다)
              
              할 일 : 저장소 처리가 잘 되는 지 확인 ==> 단위테스트
    
 */
public interface PostsRepository extends JpaRepository<Posts, Long> 
{
    
}
