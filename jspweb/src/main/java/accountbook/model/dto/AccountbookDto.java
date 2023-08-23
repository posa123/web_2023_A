package accountbook.model.dto;

public class AccountbookDto {
	private int ano;
	private String atext;
	private String anumber;
	private String adate;
	public AccountbookDto() {
		// TODO Auto-generated constructor stub
	}
	public AccountbookDto(int ano, String atext, String anumber, String adate) {
		super();
		this.ano = ano;
		this.atext = atext;
		this.anumber = anumber;
		this.adate = adate;
	}
	public AccountbookDto( String atext, String anumber , String adate) {
		super();
		this.atext = atext;
		this.anumber = anumber;
		this.adate = adate;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAtext() {
		return atext;
	}
	public void setAtext(String atext) {
		this.atext = atext;
	}
	public String getAnumber() {
		return anumber;
	}
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	@Override
	public String toString() {
		return "AccountDto [ano=" + ano + ", atext=" + atext + ", anumber=" + anumber + ", adate=" + adate + "]";
	}
	
}
