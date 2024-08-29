package com.sparta.expert.controller;

import com.sparta.expert.dto.todo.request.TodoSaveRequestDto;
import com.sparta.expert.dto.todo.response.TodoSaveResponseDto;
import com.sparta.expert.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.expert.dto.todo.response.TodoDetailResponseDto;
import com.sparta.expert.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.expert.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.expert.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    //일정 저장하기
    @PostMapping("/todos")
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto requestDto) {
        return todoService.saveTodo(requestDto);
    }
    //일정 단건조회
    @GetMapping("/todos/{todoId}")
    public TodoDetailResponseDto getTodo(@PathVariable Long todoId) {
        return todoService.getTodo(todoId);
    }
    @GetMapping("/todos")
    public Page<TodoSimpleResponseDto> getTodos(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return todoService.getTodos(page,size);
    }
    //일정 변경
    @PutMapping("todos/{todoId}")
    public TodoUpdateResponseDto updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.updateTodo(todoId,requestDto);
    }

    @DeleteMapping("todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }

}
