package com.SpringBoard.mvc.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoard.mvc.board.domain.BoardVO;
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
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO",new BoardVO());
		return "/board/write";
	}
	
	@RequestMapping(value="/board/write",method=RequestMethod.POST)
	public String write(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/write",method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) 
		{
			return "/board/write";
			
		}
		else 
		{
			boardService.write(boardVO);
			return "redirect:/board/list";
			// PRG 패턴을 적용 
		}
	}
	
	
	
}
