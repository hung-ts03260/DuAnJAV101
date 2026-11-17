package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.DanhMuc;
import util.JdbcUtil;

public class DanhMucDAO implements CrudDAO<DanhMuc, Integer> {

	// Thêm danh mục
	@Override
	public int create(DanhMuc entity) {
		String sql = "INSERT INTO DANH_MUC " + "(TenDM, MoTa, NgayTao, TrangThai) VALUES (?, ?, ?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getTenDM(), entity.getMoTa(), entity.getNgayTao(),
					entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cập nhật danh mục
	@Override
	public int update(DanhMuc entity) {
		String sql = "UPDATE DANH_MUC SET TenDM = ?, MoTa = ?, " + "NgayTao = ?, TrangThai = ? WHERE MaDM = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getTenDM(), entity.getMoTa(), entity.getNgayTao(),
					entity.isTrangThai(), entity.getMaDM());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xóa danh mục
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM DANH_MUC WHERE MaDM = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lấy danh sách danh mục
	@Override
	public List<DanhMuc> findAll() {
		List<DanhMuc> list = new ArrayList<>();
		String sql = "SELECT * FROM DANH_MUC";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				DanhMuc dm = new DanhMuc(rs.getInt("MaDM"), rs.getString("TenDM"), rs.getString("MoTa"),
						rs.getDate("NgayTao"), rs.getBoolean("TrangThai"));

				list.add(dm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tìm danh mục theo mã
	@Override
	public DanhMuc findById(Integer id) {
		String sql = "SELECT * FROM DANH_MUC WHERE MaDM = ?";
		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new DanhMuc(rs.getInt("MaDM"), rs.getString("TenDM"), rs.getString("MoTa"),
						rs.getDate("NgayTao"), rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}