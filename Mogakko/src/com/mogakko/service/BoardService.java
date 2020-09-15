package com.mogakko.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mogakko.beans.ContentBean;
import com.mogakko.beans.PageBean;
import com.mogakko.beans.UserBean;
import com.mogakko.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Value("${path.upload}")
	private String path_upload;	
	
	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name = "loginUserBean") //사용자 로그인 정보 주입
	private UserBean loginUserBean;
	
	//파일을 저장하는 메소드, 중복파일이 올라오면 덮어씌워진다. 그래서 파일이름 앞에다 현재 시간을 구해서 붙여주겠다.
	private String saveUploadFile(MultipartFile upload_file) {
		
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return file_name;
	}
	
	
	public void addContentInfo(ContentBean writeContentBean) {
		
		MultipartFile upload_file = writeContentBean.getUpload_file();
				
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}		
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		
		boardDao.addContentInfo(writeContentBean);
		
	}
	//게시판 이름 가져오기
	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}
	
	//게시판 리스트 가져오기
	public List<ContentBean> getContentList(int board_info_idx, int page){
		
		int start = (page -1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
	
	//게시글 정보 가져오기
	public ContentBean getContentInfo(int board_info_idx) {
		return boardDao.getContentInfo(board_info_idx);
	}
	
	//게시글 수정하기
	public void modifyContentInfo(ContentBean modifyContentBean) {
		
		MultipartFile upload_File = modifyContentBean.getUpload_file();
		{
		//업로드 된게 있다면 
		if(upload_File.getSize() > 0 ) {
			String file_name = saveUploadFile(upload_File);
			modifyContentBean.setContent_file(file_name);
		}	
		
		boardDao.modifyContentInfo(modifyContentBean);
		}
	}
	
	//게시글 삭제하기
	public void deleteContentInfo(int content_idx ) {
		boardDao.deleteContentInfo(content_idx);
	}
	
	//게시판번호, 현재 페이지 번호 받는다.
	public PageBean getContentCnt(int content_board_idx, int currentPage) {
		
		int content_cnt = boardDao.getContentCnt(content_board_idx);
		
		//생성자로 다음의 4개 값을 넘긴다. 
		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		
		return pageBean;
	}
	

	 


}








