package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.MemoBeans;

public class MemoDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/memoApp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "1234";

	public boolean newMemo(String title, String memo) {
		// JDBCドライバを読み込む
		try { 
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備（NUMBERは自動採番）
			String sql = "INSERT INTO MEMO_TBL("
					+ "TYTLE, MEMO)"
					+ " VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「？」に使用する値を設定してSQL文を完成
			pStmt.setString(1, title);
			pStmt.setString(2, memo);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<MemoBeans> getMemoAll() {

		List<MemoBeans> memoList = new ArrayList<>();

		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文の準備
			String sql = "SELECT  MEMO_ID, TITLE, MEMO, CREATED_AT, UPDATED_AT "
					+ "FROM MEMO_TBL WHERE deleted_flag = FALSE;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行し、結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("MEMO_ID");
				String title = rs.getString("TITLE");
				String memo = rs.getString("MEMO");
				Date created_at = rs.getDate("CREATED_ATT");
				Date updated_at = rs.getDate("UPDATED_AT");
				MemoBeans memoInf = new MemoBeans(id, title, memo, created_at, updated_at);
				memoList.add(memoInf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return memoList;

	}

	public boolean memoEdit(int id, String title, String memo) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			// UPDATE文の準備
			String sql = "UPDATE MEMO_TBL SET TITLE = ?, MEMO = ?"
					+ " WHERE MEMO_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// UPDATE文中の「？」に使用する値を設定してSQL文を完成
			pStmt.setString(1, title);
			pStmt.setString(2, memo);
			pStmt.setInt(3, id);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteMemo(int id) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		// データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			// UPDATE文の準備
			String sql = "UPDATE MEMO_TBL SET DELETED_FLAG = TRUE"
					+ " WHERE MEMO_ID = ? AND DELETED_FLAG = FALSE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// UPDATE文中の「？」に使用する値を設定してSQL文を完成
			pStmt.setInt(1, id);
			// UPDATE文を実行
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}