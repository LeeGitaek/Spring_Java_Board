package com.SpringBoard.mvc.board.domain;

import java.sql.Timestamp;
import org.apache.ibatis.type.Alias;

@Alias("boardVO")
public class BoardVO {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private int password;
	private Timestamp regDate;
	private int cnt = 0; // 초기화 
	
	
	public BoardVO() {}
	
	//public BoardVO(String title,String content,String writer, int password) { }
	//생성자에 매개변수가 4개 이상이기 때문에 세터 메서드를 적용 
	public void setBoardTitle(String strval) { title = strval; }
	public void setBoardContent(String strval) { content = strval; }
	public void setBoardWriter(String strval) { writer = strval; }
	public void setBoardPassword(int numval) { password = numval; }
	public void setBoardCnt(int numval) { cnt = numval; }
	
}


