package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.KichCo;
import util.JdbcUtil;

public class KichCoDAO implements CrudDAO<KichCo, Integer> {

	// Them kich co
	@Override
	public int create(KichCo entity) {
		String sql = "INSERT INTO KICH_CO (KichCo, TrangThai) VALUES (?, ?)";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getKichCo(), entity.isTrangThai());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Cap nhat kich co
	@Override
	public int update(KichCo entity) {
		String sql = "UPDATE KICH_CO SET KichCo = ?, " + "TrangThai = ? WHERE MaKichCo = ?";

		try {
			return JdbcUtil.executeUpdate(sql, entity.getKichCo(), entity.isTrangThai(), entity.getMaKichCo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Xoa kich co
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM KICH_CO WHERE MaKichCo = ?";

		try {
			return JdbcUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Lay danh sach kich co
	@Override
	public List<KichCo> findAll() {
		List<KichCo> list = new ArrayList<>();
		String sql = "SELECT * FROM KICH_CO";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql)) {

			while (rs.next()) {
				KichCo kc = new KichCo(rs.getInt("MaKichCo"), rs.getInt("KichCo"), rs.getBoolean("TrangThai"));

				list.add(kc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Tim kich co theo ma
	@Override
	public KichCo findById(Integer id) {
		String sql = "SELECT * FROM KICH_CO WHERE MaKichCo = ?";

		try (Connection conn = JdbcUtil.getConnection(); ResultSet rs = JdbcUtil.executeQuery(conn, sql, id)) {

			if (rs.next()) {
				return new KichCo(rs.getInt("MaKichCo"), rs.getInt("KichCo"), rs.getBoolean("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
