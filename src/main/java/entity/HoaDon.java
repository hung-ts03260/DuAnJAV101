package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HoaDon {
	private int maHD;
	private int maNV;
	private Timestamp ngayLap;
	private BigDecimal tongTien;
	private BigDecimal tienKhachDua;
	private BigDecimal tienThua;
	private boolean trangThai;

	public HoaDon() {
	}

	public HoaDon(int maHD, int maNV, Timestamp ngayLap, BigDecimal tongTien, BigDecimal tienKhachDua,
			BigDecimal tienThua, boolean trangThai) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.tienKhachDua = tienKhachDua;
		this.tienThua = tienThua;
		this.trangThai = trangThai;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public Timestamp getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Timestamp ngayLap) {
		this.ngayLap = ngayLap;
	}

	public BigDecimal getTongTien() {
		return tongTien;
	}

	public void setTongTien(BigDecimal tongTien) {
		this.tongTien = tongTien;
	}

	public BigDecimal getTienKhachDua() {
		return tienKhachDua;
	}

	public void setTienKhachDua(BigDecimal tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}

	public BigDecimal getTienThua() {
		return tienThua;
	}

	public void setTienThua(BigDecimal tienThua) {
		this.tienThua = tienThua;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
