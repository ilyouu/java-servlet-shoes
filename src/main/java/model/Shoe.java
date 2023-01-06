package model;

public class Shoe {
	protected int id_giay;
	protected String ten_giay;
	protected String ten_loai_giay;
	protected String ten_thuong_hieu;
	protected String mo_ta;
	protected String don_gia;
	protected String hinh_anh_1;
	protected String hinh_anh_2;
	protected String hinh_anh_3;
	protected String hinh_anh_4;
	
	public Shoe() {
		super();
	}

	public Shoe(String ten_giay, String ten_loai_giay, String ten_thuong_hieu, String mo_ta, String don_gia,
			String hinh_anh_1, String hinh_anh_2, String hinh_anh_3, String hinh_anh_4) {
		super();
		this.ten_giay = ten_giay;
		this.ten_loai_giay = ten_loai_giay;
		this.ten_thuong_hieu = ten_thuong_hieu;
		this.mo_ta = mo_ta;
		this.don_gia = don_gia;
		this.hinh_anh_1 = hinh_anh_1;
		this.hinh_anh_2 = hinh_anh_2;
		this.hinh_anh_3 = hinh_anh_3;
		this.hinh_anh_4 = hinh_anh_4;
	}

	public Shoe(int id_giay, String ten_giay, String ten_loai_giay, String ten_thuong_hieu, String mo_ta,
			String don_gia, String hinh_anh_1, String hinh_anh_2, String hinh_anh_3, String hinh_anh_4) {
		super();
		this.id_giay = id_giay;
		this.ten_giay = ten_giay;
		this.ten_loai_giay = ten_loai_giay;
		this.ten_thuong_hieu = ten_thuong_hieu;
		this.mo_ta = mo_ta;
		this.don_gia = don_gia;
		this.hinh_anh_1 = hinh_anh_1;
		this.hinh_anh_2 = hinh_anh_2;
		this.hinh_anh_3 = hinh_anh_3;
		this.hinh_anh_4 = hinh_anh_4;
	}

	public int getId_giay() {
		return id_giay;
	}

	public void setId_giay(int id_giay) {
		this.id_giay = id_giay;
	}

	public String getTen_giay() {
		return ten_giay;
	}

	public void setTen_giay(String ten_giay) {
		this.ten_giay = ten_giay;
	}

	public String getTen_loai_giay() {
		return ten_loai_giay;
	}

	public void setTen_loai_giay(String ten_loai_giay) {
		this.ten_loai_giay = ten_loai_giay;
	}

	public String getTen_thuong_hieu() {
		return ten_thuong_hieu;
	}

	public void setTen_thuong_hieu(String ten_thuong_hieu) {
		this.ten_thuong_hieu = ten_thuong_hieu;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	public String getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(String don_gia) {
		this.don_gia = don_gia;
	}

	public String getHinh_anh_1() {
		return hinh_anh_1;
	}

	public void setHinh_anh_1(String hinh_anh_1) {
		this.hinh_anh_1 = hinh_anh_1;
	}

	public String getHinh_anh_2() {
		return hinh_anh_2;
	}

	public void setHinh_anh_2(String hinh_anh_2) {
		this.hinh_anh_2 = hinh_anh_2;
	}

	public String getHinh_anh_3() {
		return hinh_anh_3;
	}

	public void setHinh_anh_3(String hinh_anh_3) {
		this.hinh_anh_3 = hinh_anh_3;
	}

	public String getHinh_anh_4() {
		return hinh_anh_4;
	}

	public void setHinh_anh_4(String hinh_anh_4) {
		this.hinh_anh_4 = hinh_anh_4;
	}
	
}
