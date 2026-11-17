package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.SanPham;
import util.JdbcUtil;

public class SanPhamDAO implements CrudDAO<SanPham, Integer> {

	// Them san pham
	@Override
	public int create(SanPham entity) {
		String sql = "INSERT INTO SAN_PHAM " + "(MaDM, TenSP, ThuongHieu, GiaBan, HinhAnh, TrangThai) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaDM(), entity.getTenSP(), entity.getThuongHieu(),
					entity.getGiaBan(), entity.getHinhAnh(), entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat san pham
	@Override
	public int update(SanPham entity) {
		String sql = "UPDATE SAN_PHAM SET MaDM = ?, TenSP = ?, " + "ThuongHieu = ?, GiaBan = ?, HinhAnh = ?, "
				+ "TrangThai = ? WHERE MaSP = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaDM(), entity.getTenSP(), entity.getThuongHieu(),
					entity.getGiaBan(), entity.getHinhAnh(), entity.isTrangThai(), entity.getMaSP());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa san pham
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM SAN_PHAM WHERE MaSP = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach san pham
	@Override
	public List<SanPham> findAll() {
		List<SanPham> list = new ArrayList<>();
		String sql = "SELECT * FROM SAN_PHAM";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				SanPham sp = new SanPham(rs.getInt("MaSP"), rs.getInt("MaDM"), rs.getString("TenSP"),
						rs.getString("ThuongHieu"), rs.getBigDecimal("GiaBan"), rs.getString("HinhAnh"),
						rs.getBoolean("TrangThai"));

				list.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim san pham theo ma
	@Override
	public SanPham findById(Integer id) {
		String sql = "SELECT * FROM SAN_PHAM WHERE MaSP = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new SanPham(rs.getInt("MaSP"), rs.getInt("MaDM"), rs.getString("TenSP"),
						rs.getString("ThuongHieu"), rs.getBigDecimal("GiaBan"), rs.getString("HinhAnh"),
						rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
