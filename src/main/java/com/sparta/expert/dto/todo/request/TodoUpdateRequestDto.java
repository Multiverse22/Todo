package com.sparta.expert.dto.todo.request;

import com.sparta.expert.entity.Todo;
import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private final String title;
    private final String contents;
    private final String username;

    public TodoUpdateRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
    public TodoUpdateRequestDto(Todo todo) {
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.username = todo.getUsername();
    }
}
