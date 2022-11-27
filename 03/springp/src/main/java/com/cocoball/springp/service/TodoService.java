package com.cocoball.springp.service;

import com.cocoball.springp.dto.PageRequestDTO;
import com.cocoball.springp.dto.PageResponseDTO;
import com.cocoball.springp.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    // List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);

}
