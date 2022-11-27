package com.cocoball.springp.service;

import com.cocoball.springp.dto.PageRequestDTO;
import com.cocoball.springp.dto.PageResponseDTO;
import com.cocoball.springp.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    @DisplayName("INSERT TEST")
    public void testRegister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("test")
                .dueDate(LocalDate.now())
                .writer("testuser")
                .build();
        todoService.register(todoDTO);
    }

    @Test
    @DisplayName("PAGING TEST")
    public void testPaging() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);

        log.info(responseDTO);

        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }



}