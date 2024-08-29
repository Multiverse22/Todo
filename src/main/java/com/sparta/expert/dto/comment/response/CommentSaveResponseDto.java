package com.sparta.expert.dto.comment.response;

import com.sparta.expert.entity.Comment;
import lombok.Getter;

@Getter
public class CommentSaveResponseDto {
    private final Long id;
    private final String contents;
    private final String username;


    public CommentSaveResponseDto(Long id, String contents, String username) {
        this.id = id;
        this.contents = contents;
        this.username = username;
    }

    public CommentSaveResponseDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.username = comment.getUsername();

    }
}
