package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietHoaDon;
import util.JdbcUtil;

public class ChiTietHoaDonDAO implements CrudDAO<ChiTietHoaDon, Integer> {

	// Them chi tiet hoa don
	@Override
	public int create(ChiTietHoaDon entity) {
		String sql = "INSERT INTO CHI_TIET_HOA_DON " + "(MaHD, MaSPKC, SoLuong, DonGia, ThanhTien) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaHD(), entity.getMaSPKC(), entity.getSoLuong(),
					entity.getDonGia(), entity.getThanhTien());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat chi tiet hoa don
	@Override
	public int update(ChiTietHoaDon entity) {
		String sql = "UPDATE CHI_TIET_HOA_DON SET MaHD = ?, " + "MaSPKC = ?, SoLuong = ?, DonGia = ?, "
				+ "ThanhTien = ? WHERE MaCTHD = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaHD(), entity.getMaSPKC(), entity.getSoLuong(),
					entity.getDonGia(), entity.getThanhTien(), entity.getMaCTHD());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa chi tiet hoa don
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM CHI_TIET_HOA_DON WHERE MaCTHD = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach chi tiet hoa don
	@Override
	public List<ChiTietHoaDon> findAll() {
		List<ChiTietHoaDon> list = new ArrayList<>();
		String sql = "SELECT * FROM CHI_TIET_HOA_DON";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				ChiTietHoaDon ct = new ChiTietHoaDon(rs.getInt("MaCTHD"), rs.getInt("MaHD"), rs.getInt("MaSPKC"),
						rs.getInt("SoLuong"), rs.getBigDecimal("DonGia"), rs.getBigDecimal("ThanhTien"));

				list.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim chi tiet hoa don theo ma
	@Override
	public ChiTietHoaDon findById(Integer id) {
		String sql = "SELECT * FROM CHI_TIET_HOA_DON WHERE MaCTHD = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new ChiTietHoaDon(rs.getInt("MaCTHD"), rs.getInt("MaHD"), rs.getInt("MaSPKC"),
						rs.getInt("SoLuong"), rs.getBigDecimal("DonGia"), rs.getBigDecimal("ThanhTien"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
