package com.example.springproject_ch3_01.service;

import com.example.springproject_ch3_01.dto.request.LoginRequest;
import com.example.springproject_ch3_01.dto.request.UserCreateRequest;
import com.example.springproject_ch3_01.dto.request.UserUpdateRequest;
import com.example.springproject_ch3_01.dto.response.UserCreateResponse;
import com.example.springproject_ch3_01.dto.response.UserResponse;
import com.example.springproject_ch3_01.entity.User;
import com.example.springproject_ch3_01.exception.CustomException;
import com.example.springproject_ch3_01.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성
     */
    @Transactional
    public UserCreateResponse createUser(UserCreateRequest request) {
        // Request Dto -> Entity
        User user = new User(
                request.getUserName(),
                request.getEmail(),
                request.getPassword()
        );
        // DB 저장
        User savedUser = userRepository.save(user);

        // Entity -> Response DTO 변환
        return UserCreateResponse.from(savedUser);
    }

    /**
     * 유저 로그인
     */
    @Transactional(readOnly = true)
    public void login(LoginRequest request, HttpSession session) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException(
                        HttpStatus.UNAUTHORIZED,
                        "이메일 또는 비밀번호가 올바르지 않습니다."
                ));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new CustomException(
                    HttpStatus.UNAUTHORIZED,
                    "이메일 또는 비밀번호가 올바르지 않습니다."
            );
        }

        // 세션에 로그인 정보 저장
        session.setAttribute("LOGIN_USER_ID", user.getId());
    }

    /**
     * 유저 전체 조회
     */
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    /**
     * 유저 단건 조회
     */
    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "해당 유저가 존재하지 않습니다."
                ));
        return UserResponse.from(user);
    }

    /**
     * 유저 정보 수정
     */
    @Transactional
    public UserResponse updateUser(Long id, UserUpdateRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "해당 유저가 존재하지 않습니다."
                ));
        user.update(request.getEmail());

        return UserResponse.from(user);
    }

    /**
     * 유저 삭제
     */
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "해당 유저가 존재하지 않습니다."
                ));
        userRepository.delete(user);
    }

}
