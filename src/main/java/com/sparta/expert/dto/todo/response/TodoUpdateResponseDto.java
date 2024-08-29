package com.sparta.expert.dto.todo.response;

import com.sparta.expert.entity.Todo;
import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {
    private final Long id;

    public TodoUpdateResponseDto(Todo todo) {
        this.id = todo.getId();
    }
}
