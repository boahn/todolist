package com.codestates.todolist.dto;

import lombok.Getter;

@Getter
public class TodoPatchDto {
    private Long id;

    private String title;

    private Long todo_order;

    private Boolean completed;
}
