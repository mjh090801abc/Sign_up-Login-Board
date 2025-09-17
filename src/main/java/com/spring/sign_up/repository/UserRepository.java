package com.spring.sign_up.repository;

import com.spring.sign_up.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<User, Long> : User entity를 DB랑 연결 시켜줌
public interface UserRepository extends JpaRepository<User, Long> {

    // 이름만 쓰면 sql 자동 생성
    User findByUsername(String username);
}
