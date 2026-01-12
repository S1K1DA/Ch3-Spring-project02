package com.example.springproject_ch3_01.service;

import com.example.springproject_ch3_01.dto.request.CommentCreateRequest;
import com.example.springproject_ch3_01.dto.request.CommentUpdateRequest;
import com.example.springproject_ch3_01.dto.response.CommentCreateResponse;
import com.example.springproject_ch3_01.dto.response.CommentResponse;
import com.example.springproject_ch3_01.entity.Comment;
import com.example.springproject_ch3_01.entity.Schedule;
import com.example.springproject_ch3_01.entity.User;
import com.example.springproject_ch3_01.exception.CustomException;
import com.example.springproject_ch3_01.repository.CommentRepository;
import com.example.springproject_ch3_01.repository.ScheduleRepository;
import com.example.springproject_ch3_01.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    /**
     * 댓글 생성
     */
    @Transactional
    public CommentCreateResponse createComment(Long scheduleId, Long userId, CommentCreateRequest request) {
        // 유저 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "유저가 존재하지 않습니다."
                ));

        // 일정 조회
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "일정이 존재하지 않습니다."
                ));

        // 댓글 생성
        Comment comment = new Comment(
                request.getContent(),
                user,
                schedule
        );

        Comment savedComment = commentRepository.save(comment);

        return CommentCreateResponse.from(savedComment);
    }

    /**
     * 댓글 조회
     */
    @Transactional(readOnly = true)
    public List<CommentResponse> getComments(Long scheduleId) {

        return commentRepository.findByScheduleIdOrderByCreatedAtAsc(scheduleId)
                .stream()
                .map(CommentResponse::from)
                .toList();
    }

    /**
     * 댓글 수정
     */
    @Transactional
    public CommentResponse updateComment(Long commentId, Long userId, CommentUpdateRequest request) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "댓글이 존재하지 않습니다."
                ));

        if (!comment.getUser().getId().equals(userId)) {
            throw new CustomException(
                    HttpStatus.UNAUTHORIZED,
                    "댓글 수정 권한이 없습니다."
            );
        }
        comment.update(request.getContent());

        return CommentResponse.from(comment);
    }

    /**
     * 댓글 삭제
     */
    @Transactional
    public void deleteComment(Long commentId, Long userId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(
                        HttpStatus.NOT_FOUND,
                        "댓글이 존재하지 않습니다."
                ));

        if (!comment.getUser().getId().equals(userId)) {
            throw new CustomException(
                    HttpStatus.UNAUTHORIZED,
                    "댓글 삭제 권한이 없습니다."
            );
        }
        commentRepository.delete(comment);
    }

}

