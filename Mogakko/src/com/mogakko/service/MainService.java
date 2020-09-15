package com.mogakko.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogakko.beans.ContentBean;
import com.mogakko.dao.BoardDao;

//게시글 정보를 5개까지만 보여주는 서비스
@Service
public class MainService {
	
	@Autowired
	private BoardDao boardDao;
	//게시글 리스트 가져오기
	public List<ContentBean> getMainList(int board_info_idx){
		
		RowBounds rowBounds = new RowBounds(0,7);
		
		return boardDao.getContentList(board_info_idx, rowBounds);
		
	}
	
	

}
