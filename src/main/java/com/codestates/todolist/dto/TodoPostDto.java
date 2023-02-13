package com.codestates.todolist.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TodoPostDto {
    @NotBlank
    private String title;

    @NotBlank
    private Long todo_order;

    @NotBlank
    private Boolean completed;
}
