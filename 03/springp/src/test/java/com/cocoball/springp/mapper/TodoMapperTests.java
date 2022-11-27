package com.cocoball.springp.mapper;

import com.cocoball.springp.domain.TodoVO;
import com.cocoball.springp.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    @DisplayName("INSERT TEST")
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("mtest")
                .dueDate(LocalDate.of(2022,11,27))
                .writer("mtestuser")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    @DisplayName("SELECT ALL TEST")
    public void testSelectAll() {

        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    @DisplayName("SELECT TEST")
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(1L);
        log.info(todoVO);
    }

    @Test
    @DisplayName("SEARCH TEST")
    public void testSelectSearch() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("SPRING")
                // .finished(true)
                .from(LocalDate.of(2021,12,01))
                .to(LocalDate.of(2022,12,31))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

}
