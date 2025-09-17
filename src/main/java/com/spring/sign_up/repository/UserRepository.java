package com.spring.sign_up.repository;

import com.spring.sign_up.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<User, Long> : User entity를 DB랑 연결 시켜줌
public interface UserRepository extends JpaRepository<User, Long> {

    // 이름만 쓰면 sql 자동 생성
    // SELECT * FROM user WHERE username = "내가 넣은 이름": 이런식으로 자동으로 생성
    Optional<User> findByUsername(String username);
}
