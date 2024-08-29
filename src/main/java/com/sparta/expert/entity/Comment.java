package com.sparta.expert.entity;

import com.sparta.expert.dto.comment.request.CommentSaveRequestDto;
import com.sparta.expert.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.expert.dto.comment.response.CommentSaveResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;
    private String username;
    //ManyToOne은 왠만하면 붙여야한다.
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn은 상대방의 id를 적으면된다.
    //상대방은 Todo니깐 todo_id를 적으면된다.
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment (CommentSaveRequestDto requestDto,Todo todo) {
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.todo = todo;
    }

    public void update(CommentUpdateRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
