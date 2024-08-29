package com.sparta.expert.controller;

import com.sparta.expert.dto.comment.request.CommentSaveRequestDto;
import com.sparta.expert.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.expert.dto.comment.response.CommentDetailResponseDto;
import com.sparta.expert.dto.comment.response.CommentSaveResponseDto;
import com.sparta.expert.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.expert.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.expert.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long todoId,@RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(todoId,requestDto);
    }
    // 단건조회
    @GetMapping("/todos/comments/{commentId}")
    public CommentDetailResponseDto getComment( @PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }
    //특정 id의 일정을 받아 전체 댓글을 조회
    @GetMapping("/todos/{todoId}/comments")
    public List<CommentDetailResponseDto> getComments(@PathVariable Long todoId) {
        return commentService.getComments(todoId);
    }

    //일정 변경
    @PutMapping("/comments/{commentId}")
    public CommentUpdateResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return commentService.updateComment(commentId,requestDto);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
