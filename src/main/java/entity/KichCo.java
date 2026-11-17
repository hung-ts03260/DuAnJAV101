package entity;

public class KichCo {
	private int maKichCo;
	private int kichCo;
	private boolean trangThai;

	public KichCo() {
	}

	public KichCo(int maKichCo, int kichCo, boolean trangThai) {
		this.maKichCo = maKichCo;
		this.kichCo = kichCo;
		this.trangThai = trangThai;
	}

	public int getMaKichCo() {
		return maKichCo;
	}

	public void setMaKichCo(int maKichCo) {
		this.maKichCo = maKichCo;
	}

	public int getKichCo() {
		return kichCo;
	}

	public void setKichCo(int kichCo) {
		this.kichCo = kichCo;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

}
