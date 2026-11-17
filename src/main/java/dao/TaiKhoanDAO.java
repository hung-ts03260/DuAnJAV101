package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TaiKhoan;
import util.JdbcUtil;

public class TaiKhoanDAO implements CrudDAO<TaiKhoan, Integer> {

	// Them tai khoan
	@Override
	public int create(TaiKhoan entity) {
		String sql = "INSERT INTO TAI_KHOAN " + "(TenDangNhap, MatKhau, VaiTro, TrangThai, MaNV) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getTenDangNhap(), entity.getMatKhau(), entity.getVaiTro(),
					entity.isTrangThai(), entity.getMaNV());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat tai khoan
	@Override
	public int update(TaiKhoan entity) {
		String sql = "UPDATE TAI_KHOAN SET TenDangNhap = ?, " + "MatKhau = ?, VaiTro = ?, TrangThai = ?, "
				+ "MaNV = ? WHERE MaTK = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getTenDangNhap(), entity.getMatKhau(), entity.getVaiTro(),
					entity.isTrangThai(), entity.getMaNV(), entity.getMaTK());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa tai khoan
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM TAI_KHOAN WHERE MaTK = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach tai khoan
	@Override
	public List<TaiKhoan> findAll() {
		List<TaiKhoan> list = new ArrayList<>();
		String sql = "SELECT * FROM TAI_KHOAN";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getInt("MaTK"), rs.getString("TenDangNhap"), rs.getString("MatKhau"),
						rs.getString("VaiTro"), rs.getBoolean("TrangThai"), rs.getInt("MaNV"));

				list.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim tai khoan theo ma
	@Override
	public TaiKhoan findById(Integer id) {
		String sql = "SELECT * FROM TAI_KHOAN WHERE MaTK = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new TaiKhoan(rs.getInt("MaTK"), rs.getString("TenDangNhap"), rs.getString("MatKhau"),
						rs.getString("VaiTro"), rs.getBoolean("TrangThai"), rs.getInt("MaNV"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
