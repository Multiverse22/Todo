package com.sparta.expert.dto.todo.response;

import com.sparta.expert.entity.Todo;
import lombok.Getter;

@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final String username;

    public TodoDetailResponseDto(Long id, String title, String contents, String username) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public TodoDetailResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.username = todo.getUsername();
    }
}
