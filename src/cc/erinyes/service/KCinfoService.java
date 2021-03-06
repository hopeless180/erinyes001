package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.GXinfo;
import cc.erinyes.model.KCinfo;

public class KCinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public KCinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addKC(KCinfo KC) {
		try {
			pstmt = conn.prepareStatement("insert into KC"
					+ "(KC_NO, KC_NAME, KC_QUANTITY, KC_CONTENT) "
					+ "values(?,?,?,?)");
			pstmt.setString(1, KC.getno());
			pstmt.setString(2, KC.getname());
			pstmt.setInt(3, KC.getquantity());
			pstmt.setString(4, KC.getcontent());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllKC() {
		List KCL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from KC");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				KCinfo KC = new KCinfo();
				KC.setid(rs.getInt(5));
				KC.setno(rs.getString(1));
				KC.setname(rs.getString(2));
				KC.setquantity(rs.getInt(3));
				KC.setcontent(rs.getString(4));
				KCL.add(KC);
			}
			return KCL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public KCinfo queryKCbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from KC where KC_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				KCinfo KC = new KCinfo();
				KC.setid(rs.getInt(5));
				KC.setno(rs.getString(1));
				KC.setname(rs.getString(2));
				KC.setquantity(rs.getInt(3));
				KC.setcontent(rs.getString(4));
				return KC;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateKC(KCinfo KC) {

		try {
			pstmt = conn
					.prepareStatement("update KC set KC_NO = ?, KC_NAME = ?, "
							+ "KC_QUANTITY = ?,KC_CONTENT = ?	where KC_ID = ?");
			pstmt.setString(1, KC.getno());
			pstmt.setString(2, KC.getname());
			pstmt.setInt(3, KC.getquantity());
			pstmt.setString(4, KC.getcontent());
			
			pstmt.setInt(5, KC.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteKC(int id) {

		try {
			pstmt = conn.prepareStatement("delete from KC where KC_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table KC drop KC_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table KC add KC_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(KC_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
