package com.sparta.expert.service;

import com.sparta.expert.dto.todo.request.TodoSaveRequestDto;
import com.sparta.expert.dto.todo.response.TodoSaveResponseDto;
import com.sparta.expert.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.expert.dto.todo.response.TodoDetailResponseDto;
import com.sparta.expert.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.expert.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.expert.entity.Todo;
import com.sparta.expert.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo newtodo = new Todo(requestDto);
        Todo savedTodo = todoRepository.save(newtodo);
        return new TodoSaveResponseDto(savedTodo);
    }
    //일정 단건 조회
    @Transactional
    public TodoDetailResponseDto getTodo(Long id) {
        Todo todo=findTodo(id);
        return new TodoDetailResponseDto(todo);
    }
    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto requestDto) {
        Todo todo=findTodo(todoId);
        todo.update(requestDto);
        return new TodoUpdateResponseDto(todo);
    }
    @Transactional
    public Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(()->new NullPointerException("Todo not found"));
    }
    @Transactional
    public void deleteTodo(Long todoId) {
        Todo todo = findTodo(todoId);
        todoRepository.delete(todo);
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo-> new TodoSimpleResponseDto(
                todo.getTitle()
        ));
    }
}
