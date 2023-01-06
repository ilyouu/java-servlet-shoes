package model;

public class User {
	protected int id;
	protected String ten_nguoi_dung;
	protected String email;
	protected String password;
	protected String phan_quyen;
	
	public User() {
		super();
	}
	
	public User(String ten_nguoi_dung, String email, String password, String phan_quyen) {
		super();
		this.ten_nguoi_dung = ten_nguoi_dung;
		this.email = email;
		this.password = password;
		this.phan_quyen = phan_quyen;
	}

	public User(int id, String ten_nguoi_dung, String email, String password, String phan_quyen) {
		super();
		this.id = id;
		this.ten_nguoi_dung = ten_nguoi_dung;
		this.email = email;
		this.password = password;
		this.phan_quyen = phan_quyen;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_nguoi_dung() {
		return ten_nguoi_dung;
	}
	public void setTen_nguoi_dung(String ten_nguoi_dung) {
		this.ten_nguoi_dung = ten_nguoi_dung;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhan_quyen() {
		return phan_quyen;
	}
	public void setPhan_quyen(String phan_quyen) {
		this.phan_quyen = phan_quyen;
	}
}
