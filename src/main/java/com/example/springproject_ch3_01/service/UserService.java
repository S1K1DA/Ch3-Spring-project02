package com.example.springproject_ch3_01.service;

import com.example.springproject_ch3_01.dto.request.UserCreateRequest;
import com.example.springproject_ch3_01.dto.response.UserCreateResponse;
import com.example.springproject_ch3_01.entity.User;
import com.example.springproject_ch3_01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성
     */
    public UserCreateResponse createUser(UserCreateRequest request) {

        // Request Dto -> Entity
        User user = new User(
                request.getUserName(),
                request.getEmail()
        );
        // DB 저장
        User savedUser = userRepository.save(user);

        // Entity -> Response DTO 변환
        return UserCreateResponse.from(savedUser);
    }
}
