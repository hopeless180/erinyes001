package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.CKinfo;
import cc.erinyes.model.RKinfo;

public class RKinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public RKinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addRK(RKinfo RK) {
		try {
			pstmt = conn.prepareStatement("insert into RK"
					+ "(RK_NO, RK_NAME, RK_QUANTITY, RK_CONTENT, RK_USER, RK_DATE) "
					+ "values(?,?,?,?,?,?)");
			pstmt.setString(1, RK.getno());
			pstmt.setString(2, RK.getname());
			pstmt.setInt(3, RK.getquantity());
			pstmt.setString(4, RK.getcontent());
			pstmt.setString(5, RK.getuser());
			pstmt.setString(6, RK.getdate());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllRK() {
		List RKL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from RK");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RKinfo RK = new RKinfo();
				RK.setid(rs.getInt(7));
				RK.setno(rs.getString(1));
				RK.setname(rs.getString(2));
				RK.setquantity(rs.getInt(3));
				RK.setcontent(rs.getString(4));
				RK.setuser(rs.getString(5));
				RK.setdate(rs.getString(6));
				
				RKL.add(RK);
			}
			return RKL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public RKinfo queryRKbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from RK where RK_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				RKinfo RK = new RKinfo();
				RK.setid(rs.getInt(7));
				RK.setno(rs.getString(1));
				RK.setname(rs.getString(2));
				RK.setquantity(rs.getInt(3));
				RK.setcontent(rs.getString(4));
				RK.setuser(rs.getString(5));
				RK.setdate(rs.getString(6));
				return RK;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public boolean updateRK(RKinfo RK) {

		try {
			pstmt = conn
					.prepareStatement("update RK set RK_NO = ?, RK_NAME = ?, "
							+ "RK_QUANTITY = ?, RK_CONTENT = ?, RK_USER = ?, RK_DATE = ?	where RK_ID = ?");
			pstmt.setString(1, RK.getno());
			pstmt.setString(2, RK.getname());
			pstmt.setInt(3, RK.getquantity());
			pstmt.setString(4, RK.getcontent());
			pstmt.setString(5, RK.getuser());
			pstmt.setString(6, RK.getdate());
			
			pstmt.setInt(7, RK.getid());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteRK(int id) {

		try {
			pstmt = conn.prepareStatement("delete from RK where RK_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table RK drop RK_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table RK add RK_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(RK_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
