package com.mogakko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.mogakko.beans.UserBean;

//프로젝트 작업시 사용할 bean을 정의하는 클래스 root-context.xml 대신 만든거
//프로젝트 설정과 관련된 bean은 ServletAppContext.javadp, 데이터저장, 괄리 목적의 빈은 여기에 정의
@Configuration
public class RootAppContext {
	
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}

}
