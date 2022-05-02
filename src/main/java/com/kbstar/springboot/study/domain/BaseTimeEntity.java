package com.kbstar.springboot.study.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/*
    30 : JPA Auditing(감시)
    게시글의 등록, 수정날짜를 자동 관리

    @MappedSuperclass
        JPA Entity Class 들이 BaseTimeEntity(현재 클래스) 상속받게 할 예정
        상속받으면 createDate, modifiedDate 컬럼으로 인식하게 함

    @EntityListeners() : BaseTimeEntity 클래스에 Auditing 기능을 포함시키겠다.

    이 BaseTimeEntity 클래스를 Posts에서 상속받도록 변경 예정

 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity
{
    @CreatedDate
    // private LocalDateTime createDate;
    private String createDate;

    @LastModifiedDate
    // private LocalDateTime modifiedDate;
    private String modifiedDate;

    @PrePersist
    public void onPrePersist()  // 해당 Entity를 DB넣기전에(저장하기전에) 미리 내부적으로 처리(실행)
    {
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @PreUpdate
    public void onPreUpdate()  // 해당 Entity를 수정하기전에 미리 내부적으로 처리(실행)
    {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}
