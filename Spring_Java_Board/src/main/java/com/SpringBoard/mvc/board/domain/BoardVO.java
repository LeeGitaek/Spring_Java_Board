package com.SpringBoard.mvc.board.domain;

import java.sql.Timestamp;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length; // length
import org.hibernate.validator.constraints.NotEmpty; // not empty

@Alias("boardVO")
public class BoardVO {
	private int seq;
	@Length(min=2,max=5, message="제목은 2자 이상,5자 미만 입력하세요.")
	private String title;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	@NotEmpty(message="작성자를 입력하세요.")
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


