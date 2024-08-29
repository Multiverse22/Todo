package com.sparta.expert.dto.comment.request;

import com.sparta.expert.entity.Comment;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private String contents;
    private String username;

    public CommentUpdateRequestDto(Comment comment) {
        this.contents = comment.getContents();
        this.username = comment.getUsername();
    }
}
