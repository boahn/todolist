package com.codestates.todolist.Service;

import com.codestates.todolist.dto.TodoPatchDto;
import com.codestates.todolist.dto.TodoPostDto;
import com.codestates.todolist.entity.Todo;
import com.codestates.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(TodoPostDto todoPostDto) {
        Todo todo = new Todo();
        todo.setTitle(todoPostDto.getTitle());
        todo.setTodo_order(todoPostDto.getTodo_order());
        todo.setCompleted(todoPostDto.getCompleted());

        return this.todoRepository.save(todo);
    }

    public Todo readTodo(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Todo> readAllTodo() {
        return todoRepository.findAll();
    }

    public Todo updatTodo(Long id, TodoPatchDto todoPatchDto) {
        Todo todo = this.readTodo(id);
        if (todoPatchDto.getTitle() != null) {
            todo.setTitle(todoPatchDto.getTitle());
        }
        if (todoPatchDto.getTodo_order() != null) {
            todo.setTodo_order(todoPatchDto.getTodo_order());
        }
        if (todoPatchDto.getCompleted() != null) {
            todo.setCompleted(todoPatchDto.getCompleted());
        }
        return this.todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAllTodo() {
        this.todoRepository.deleteAll();
    }
}
