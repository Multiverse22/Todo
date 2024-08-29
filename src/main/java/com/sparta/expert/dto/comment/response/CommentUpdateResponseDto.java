package com.sparta.expert.dto.comment.response;

import com.sparta.expert.entity.Comment;
import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String contents;
    private final String username;

    public CommentUpdateResponseDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.username = comment.getUsername();
    }
}
