package model.dto;

public class HrmDto {
	private String himg;
	private String hname;
	private String hphone;
	private String hposition;
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}
	public HrmDto(String himg, String hname, String hphone, String hposition) {
		super();
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hposition = hposition;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getHposition() {
		return hposition;
	}
	public void setHposition(String hposition) {
		this.hposition = hposition;
	}
	@Override
	public String toString() {
		return "HrmDto [himg=" + himg + ", hname=" + hname + ", hphone=" + hphone + ", hposition=" + hposition + "]";
	}
	
}
