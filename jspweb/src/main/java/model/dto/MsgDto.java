package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.MemberDao;

public class MsgDto {
   
   private String frommid;   // 보낸사람
   private String msg;   // 보낸내용
   private String frommimg;
   private String date;
	   
	public MsgDto() {
		// TODO Auto-generated constructor stub
	}
	public MsgDto( String frommid , String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		
		// 객체 생성시 추가코드
			// 1. 보낸사람의 프로필 가져오기
			this.frommimg = MemberDao.getInstance().info(frommid).getMimg();
			
			// 2. 보낸일시 구하기
			Date date = new Date(); System.out.println("현재날짜/시간:" + date);
			
			SimpleDateFormat sdf = new SimpleDateFormat(" aa hh:mm");
			
			this.date = sdf.format(date); // 현재시간을 정의한형식으로 변환
	}
	public MsgDto(String frommid, String msg, String frommimg, String date) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		this.frommimg = frommimg;
		this.date = date;
	}
	public String getFrommid() {
		return frommid;
	}
	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFrommimg() {
		return frommimg;
	}
	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + ", frommimg=" + frommimg + ", date=" + date + "]";
	}
	
	
}