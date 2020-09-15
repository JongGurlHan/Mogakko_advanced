package com.mogakko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogakko.beans.BoardInfoBean;
import com.mogakko.beans.ContentBean;
import com.mogakko.service.BoardService;
import com.mogakko.service.MainService;
import com.mogakko.service.TopMenuService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Autowired
	private BoardService boardService;
	
		
	
	@GetMapping("/main_bulletin")
	public String main_bulletin(Model model) {
		
		//게시글 리스트 가져오기
		ArrayList<List<ContentBean>> list = new ArrayList<List<ContentBean>>();
		
		for(int i = 1; i <= 2; i++) {
			List<ContentBean> list1 = mainService.getMainList(i);
			list.add(list1);
		}
		
		model.addAttribute("list", list);	
		
		//게시판 이름 가져오기
		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list" , board_list);
		
				
		return "main/main_bulletin";
	}
	
	
	@GetMapping("/main_map")
	public String main_map(Model model) {
		
			 
		return "main/main_map";
	}	
	

}
