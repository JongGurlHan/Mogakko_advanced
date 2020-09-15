package com.mogakko.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mogakko.beans.ContentBean;
import com.mogakko.beans.UserBean;
import com.mogakko.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor {
	
	//인터셉터는 bean주입이 안되므로 생성자 통해서 받는다.	
	private UserBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		
		//현재 글정보 가져오기		
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		//작성자와 로그인한 사람이 다르면 not_writer요청
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			return false;
		}
		return true;		
		
	}
	
	
}
