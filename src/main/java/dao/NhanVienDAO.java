package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import util.JdbcUtil;

public class NhanVienDAO implements CrudDAO<NhanVien, Integer> {

	@Override
	public int create(NhanVien entity) {
		String sql = "INSERT INTO NHAN_VIEN " + "(HoTen, GioiTinh, NgaySinh, SoDienThoai, DiaChi, TrangThai) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getHoTen(), entity.isGioiTinh(), entity.getNgaySinh(),
					entity.getSoDienThoai(), entity.getDiaChi(), entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(NhanVien entity) {
		String sql = "UPDATE NHAN_VIEN SET HoTen = ?, GioiTinh = ?, " + "NgaySinh = ?, SoDienThoai = ?, DiaChi = ?, "
				+ "TrangThai = ? WHERE MaNV = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getHoTen(), entity.isGioiTinh(), entity.getNgaySinh(),
					entity.getSoDienThoai(), entity.getDiaChi(), entity.isTrangThai(), entity.getMaNV());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM NHAN_VIEN WHERE MaNV = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<NhanVien> findAll() {
		List<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM NHAN_VIEN";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getInt("MaNV"), rs.getString("HoTen"), rs.getBoolean("GioiTinh"),
						rs.getDate("NgaySinh"), rs.getString("SoDienThoai"), rs.getString("DiaChi"),
						rs.getBoolean("TrangThai"));

				list.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public NhanVien findById(Integer id) {
		String sql = "SELECT * FROM NHAN_VIEN WHERE MaNV = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new NhanVien(rs.getInt("MaNV"), rs.getString("HoTen"), rs.getBoolean("GioiTinh"),
						rs.getDate("NgaySinh"), rs.getString("SoDienThoai"), rs.getString("DiaChi"),
						rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
