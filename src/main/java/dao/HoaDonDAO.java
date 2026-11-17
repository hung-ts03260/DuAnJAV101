package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import util.JdbcUtil;

public class HoaDonDAO implements CrudDAO<HoaDon, Integer> {

	// Them hoa don
	@Override
	public int create(HoaDon entity) {
		String sql = "INSERT INTO HOA_DON " + "(MaNV, NgayLap, TongTien, TienKhachDua, TienThua, TrangThai) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaNV(), entity.getNgayLap(), entity.getTongTien(),
					entity.getTienKhachDua(), entity.getTienThua(), entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat hoa don
	@Override
	public int update(HoaDon entity) {
		String sql = "UPDATE HOA_DON SET MaNV = ?, NgayLap = ?, " + "TongTien = ?, TienKhachDua = ?, TienThua = ?, "
				+ "TrangThai = ? WHERE MaHD = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaNV(), entity.getNgayLap(), entity.getTongTien(),
					entity.getTienKhachDua(), entity.getTienThua(), entity.isTrangThai(), entity.getMaHD());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa hoa don
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM HOA_DON WHERE MaHD = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach hoa don
	@Override
	public List<HoaDon> findAll() {
		List<HoaDon> list = new ArrayList<>();
		String sql = "SELECT * FROM HOA_DON";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getInt("MaHD"), rs.getInt("MaNV"), rs.getTimestamp("NgayLap"),
						rs.getBigDecimal("TongTien"), rs.getBigDecimal("TienKhachDua"), rs.getBigDecimal("TienThua"),
						rs.getBoolean("TrangThai"));

				list.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim hoa don theo ma
	@Override
	public HoaDon findById(Integer id) {
		String sql = "SELECT * FROM HOA_DON WHERE MaHD = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new HoaDon(rs.getInt("MaHD"), rs.getInt("MaNV"), rs.getTimestamp("NgayLap"),
						rs.getBigDecimal("TongTien"), rs.getBigDecimal("TienKhachDua"), rs.getBigDecimal("TienThua"),
						rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
