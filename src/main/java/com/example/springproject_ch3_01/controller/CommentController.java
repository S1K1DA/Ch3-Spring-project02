package com.example.springproject_ch3_01.controller;

import com.example.springproject_ch3_01.dto.request.CommentCreateRequest;
import com.example.springproject_ch3_01.dto.request.CommentUpdateRequest;
import com.example.springproject_ch3_01.dto.response.CommentCreateResponse;
import com.example.springproject_ch3_01.dto.response.CommentResponse;
import com.example.springproject_ch3_01.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 생성
     */
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentCreateResponse> createComment(@PathVariable Long scheduleId, @SessionAttribute("LOGIN_USER_ID") Long userId,@Valid @RequestBody CommentCreateRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.createComment(scheduleId, userId, request));
    }

    /**
     * 댓글 전체 조회
     */
    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(commentService.getComments(scheduleId));
    }

    /**
     * 댓글 수정
     */
    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId, @SessionAttribute("LOGIN_USER_ID") Long userId,@Valid @RequestBody CommentUpdateRequest request) {
        return ResponseEntity.ok(
                commentService.updateComment(commentId, userId, request)
        );
    }

    /**
     * 댓글 삭제
     */
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId, @SessionAttribute("LOGIN_USER_ID") Long userId) {
        commentService.deleteComment(commentId, userId);
        return ResponseEntity.noContent().build();
    }
}
