package com.mogakko.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mogakko.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor {
	
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(loginUserBean.isUserLogin() ==  false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			return false; //인터셉터 프리핸들에서 false하면 그 다음단계로 이동하지 않고 여기서 그냥 끝난다. 
		}
		return true; //로그인 했다면 true 해서 다음단계 (컨트롤러)로 이동 
	}

}
