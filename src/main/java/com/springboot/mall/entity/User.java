package com.springboot.mall.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id") // 데이터베이스 컬럼명과 일치시킵니다.
    private String userId;

    private String userPw;
    private String userName;
}
