package com.cocoball.springp.controller;

import com.cocoball.springp.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("todo list 호출");
    }

    @GetMapping("/register")
    public void register() {
        log.info("todo list 등록 페이지");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("todo list 등록");
        log.info(todoDTO);
    }

}
