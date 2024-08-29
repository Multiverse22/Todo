package com.sparta.expert.service;

import com.sparta.expert.dto.comment.request.CommentSaveRequestDto;
import com.sparta.expert.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.expert.dto.comment.response.CommentDetailResponseDto;
import com.sparta.expert.dto.comment.response.CommentSaveResponseDto;
import com.sparta.expert.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.expert.entity.Comment;
import com.sparta.expert.entity.Todo;
import com.sparta.expert.repository.CommentRepository;
import com.sparta.expert.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public CommentSaveResponseDto saveComment(Long todoId,CommentSaveRequestDto commentSaveRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("Todo not found"));
        Comment newcomment = new Comment(commentSaveRequestDto,todo);

        Comment savedcomment = commentRepository.save(newcomment);

        return new CommentSaveResponseDto(savedcomment);
    }
    //일정 다건 조회
    @Transactional
    public List<CommentDetailResponseDto> getComments(Long todoId) {
        //todoId로 댓글리스트를 받아온다.
        List<Comment> commentList = commentRepository.findByTodoId(todoId);
        //향상된포문으로 <Comment> 타입을 <CommentDetailResponseDto> 으로 형변환
        List<CommentDetailResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentDetailResponseDto Dto = new CommentDetailResponseDto(comment);
            dtoList.add(Dto);
        }
        return dtoList;
    }
    @Transactional
    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = findCommentById(commentId);

        return new CommentDetailResponseDto(comment);
    }
    @Transactional
    //업데이트
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = findCommentById(commentId);
        comment.update(commentUpdateRequestDto);
        return new CommentUpdateResponseDto(comment);
    }

    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("Comment not found"));
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NullPointerException("Comment not found");
        }
        commentRepository.deleteById(commentId);
    }
}
