package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.SanPhamKichCo;
import util.JdbcUtil;

public class SanPhamKichCoDAO implements CrudDAO<SanPhamKichCo, Integer> {

	// Them san pham theo kich co
	@Override
	public int create(SanPhamKichCo entity) {
		String sql = "INSERT INTO SAN_PHAM_KICH_CO " + "(MaSP, MaKichCo, SoLuongTon, NgayCapNhat, TrangThai) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaSP(), entity.getMaKichCo(), entity.getSoLuongTon(),
					entity.getNgayCapNhat(), entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat san pham theo kich co
	@Override
	public int update(SanPhamKichCo entity) {
		String sql = "UPDATE SAN_PHAM_KICH_CO SET MaSP = ?, " + "MaKichCo = ?, SoLuongTon = ?, NgayCapNhat = ?, "
				+ "TrangThai = ? WHERE MaSPKC = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getMaSP(), entity.getMaKichCo(), entity.getSoLuongTon(),
					entity.getNgayCapNhat(), entity.isTrangThai(), entity.getMaSPKC());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa san pham theo kich co
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM SAN_PHAM_KICH_CO WHERE MaSPKC = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach
	@Override
	public List<SanPhamKichCo> findAll() {
		List<SanPhamKichCo> list = new ArrayList<>();
		String sql = "SELECT * FROM SAN_PHAM_KICH_CO";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				SanPhamKichCo spkc = new SanPhamKichCo(rs.getInt("MaSPKC"), rs.getInt("MaSP"), rs.getInt("MaKichCo"),
						rs.getInt("SoLuongTon"), rs.getTimestamp("NgayCapNhat"), rs.getBoolean("TrangThai"));

				list.add(spkc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim theo ma
	@Override
	public SanPhamKichCo findById(Integer id) {
		String sql = "SELECT * FROM SAN_PHAM_KICH_CO WHERE MaSPKC = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new SanPhamKichCo(rs.getInt("MaSPKC"), rs.getInt("MaSP"), rs.getInt("MaKichCo"),
						rs.getInt("SoLuongTon"), rs.getTimestamp("NgayCapNhat"), rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
