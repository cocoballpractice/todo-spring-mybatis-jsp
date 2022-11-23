package com.cocoball.jdbctest.service;

import com.cocoball.jdbctest.dao.TodoDAO;
import com.cocoball.jdbctest.domain.TodoVO;
import com.cocoball.jdbctest.dto.TodoDTO;
import com.cocoball.jdbctest.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        System.out.println("todoVO: " + todoVO);
        dao.insert(todoVO); // int를 반환하므로 이를 이용해서 예외 처리도 가능
    }

}
