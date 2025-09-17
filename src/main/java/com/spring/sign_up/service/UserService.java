package com.spring.sign_up.service;

import com.spring.sign_up.entity.User;
import com.spring.sign_up.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // 생성자: Spring이 UserRepository를 넣어줌 (의존성 주입)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입 (중복체크 후 저장)
    @Transactional
    public User registerUser(String username, String password, String email) {
        // 같은 아이디가 이미 있으면 예외를 던져서 처리 중단
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // User 객체 생성 (지금은 비밀번호 평문 저장 — 나중에 암호화 필요)
        User user = new User(username, password, email);

        // DB에 저장하고 저장된 엔티티(User)를 반환
        return userRepository.save(user);
    }

    // 로그인 (조회만 하므로 readOnly)
    @Transactional(readOnly = true)
    public Optional<User> login(String username, String password) {
        // username으로 사용자 찾고, 찾으면 password 비교하여 Optional로 반환
        return userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    // 유틸 메서드: username으로 회원정보 조회 (컨트롤러에서 필요할 때 사용)
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
