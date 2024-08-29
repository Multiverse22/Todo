package com.sparta.expert.entity;

import com.sparta.expert.dto.todo.request.TodoSaveRequestDto;
import com.sparta.expert.dto.todo.request.TodoUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    private String username;
    //원투매니는 mappedBy에 자기자신을 넣어준다고 생각하자.
    @OneToMany(mappedBy = "todo")
    private List<Comment> comments = new ArrayList<>();

    public Todo(TodoSaveRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
    }

    public void update(TodoUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
    }
}
