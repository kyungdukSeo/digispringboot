/*
    PostRepository.interface

    Posts 클래스에서 실제로 DB 접근이 가능하게 해주는 역할을 수행하며,
    실제 query 를 작성하여 프로그래밍된 기능이 DB에 저장, 업데이트, 수정 될수 있도록 쿼리를 날려준다.
    추가기능으로 DB에 쿼리를 할때 page를 구분해 가져올수 있는 기능을 제공한다.

    select가 아닌 DB에 영향이 미치는 쿼리의 경우 @Modifying 어노테이션을 사용한다.
 */


package com.kbstar.springboot.study.domain.posts;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
/*
    38. 여기서 사용하는 쿼리는 RDB와 약간 차이가 있다. JPQL
 */
public interface PostsRepository extends JpaRepository<Posts, Long> 
{
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    @Modifying // data에 영향을 미치는 경우 사용 insert, delete, update
    @Query("UPDATE Posts p SET p.view = p.view + 1 WHERE p.id = :id ")
    int updateView(Long id);
    //    int updateView(@Param("id") Long id);   --> 버전 안맞으면 param 써줘야..

    @Modifying
    @Query("UPDATE Posts p SET p.rec = p.rec + 1 WHERE p.id = :id ")
    int increaseRecommend(Long id);

    // @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    // Page<Posts> findAllPage(@Param("pageable") Pageable Pageable);


    // Select * from where title title like'%key%'
    // List<Posts> findByTitleContaining(String key);
    // 검색 전체 목록

    Page<Posts> findByTitleContaining(String key, Pageable pageable);
    // 검색 페이지 단위로
}
