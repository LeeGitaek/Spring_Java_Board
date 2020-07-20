package com.SpringBoard.mvc.board.service;

import java.util.List;
import javax.annoation.Resource;
import org.springframework.stereotype.Service;
import com.SpringBoard.mvc.board.dao.BoardDao;
import com.SpringBoard.mvc.board.domain.BoardVO;

@Service
public class BoardServicelmpl implements BoardService {
	@Resource
	private BoardDao boardDao;
	
	public BoardDao getBoardDao() {
		return boardDao;
	}
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	
	@Override
	public List<BoardVO> list(){
		return boardDao.list();
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return boardDao.delete(boardVO);
	}
	
	@Override 
	public int edit(BoardVO boardVO) {
		return boardDao.update(boardVO);
	}
	
	@Override
	public void write(BoardVO boardVO) {
		boardDao.insert(boardVO);
	}
	
	@Override 
	public BoardVO read(int seq) {
		boardDao.updateReadCount(seq);
		return boardDao.select(seq);
	}
	
	
}
