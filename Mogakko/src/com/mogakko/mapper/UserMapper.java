package com.mogakko.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mogakko.beans.UserBean;

public interface UserMapper {
	
	@Select("SELECT user_name FROM gojkhan13.user_table WHERE user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	@Insert("INSERT INTO gojkhan13.user_table(user_name, user_id, user_pw)"+
			"VALUES (#{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("SELECT user_idx, user_name FROM gojkhan13.user_table WHERE user_id = #{user_id} and user_pw = #{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	//현재 로그인한 사용자 인덱스 번호로
	@Select("select user_id, user_name from gojkhan13.user_table where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(int user_idx);

	@Update("update gojkhan13.user_table set user_pw = #{user_pw} where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
}
