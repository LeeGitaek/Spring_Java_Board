package com.SpringBoard.mvc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoard.mvc.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list")
	@ResponseBody
	public String list(Model model) {
		model.addAttribute("boardList",boardService.list());
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVO",boardService.read(seq));
		return "/board/read";
	}
	
	@RequestMapping(value="/board/write")
	public String write() {
		return "/board/write";
	}
	
	
}
