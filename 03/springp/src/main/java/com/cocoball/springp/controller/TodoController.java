package com.cocoball.springp.controller;

import com.cocoball.springp.dto.PageRequestDTO;
import com.cocoball.springp.dto.TodoDTO;
import com.cocoball.springp.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult,
                     Model model) {

        log.info("todo list 호출");
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()) {
            pageRequestDTO = pageRequestDTO.builder().build();
        }

        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {

        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("todo list 등록 페이지");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo list 등록");

        if(bindingResult.hasErrors()) {
            log.info("오류 발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @PostMapping("/remove")
    public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {

        log.info("todo list 삭제");
        log.info("tno: " + tno);

        todoService.remove(tno);

        redirectAttributes.addAttribute("page", 1); // 1페이지로 이동
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/list";

    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            log.info("오류 발생");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/list";

    }

}
