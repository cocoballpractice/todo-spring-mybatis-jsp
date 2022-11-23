package com.cocoball.jdbctest.controller;

import com.cocoball.jdbctest.dto.TodoDTO;
import com.cocoball.jdbctest.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", value = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("--todo list.......--");

        try {
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList); // setAttribute를 통해 TodoService가 반환하는 데이터 저장 후
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp); // list.jsp로 전달
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error!");
        }

    }

}
