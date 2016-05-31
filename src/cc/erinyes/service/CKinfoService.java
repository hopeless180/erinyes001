package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.CAinfo;
import cc.erinyes.model.CKinfo;

public class CKinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public CKinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addCK(CKinfo CK) {
		try {
			pstmt = conn.prepareStatement("insert into CK"
					+ "(CK_NO, CK_NAME, CK_QUANTITY, CK_CONTENT, CK_USER, CK_DATE) "
					+ "values(?,?,?,?,?,?)");
			pstmt.setString(1, CK.getno());
			pstmt.setString(2, CK.getname());
			pstmt.setInt(3, CK.getquantity());
			pstmt.setString(4, CK.getcontent());
			pstmt.setString(5, CK.getuser());
			pstmt.setString(6, CK.getdate());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllCK() {
		List CKL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from CK");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CKinfo CK = new CKinfo();
				CK.setid(rs.getInt(7));
				CK.setno(rs.getString(1));
				CK.setname(rs.getString(2));
				CK.setquantity(rs.getInt(3));
				CK.setcontent(rs.getString(4));
				CK.setuser(rs.getString(5));
				CK.setdate(rs.getString(6));

				CKL.add(CK);
			}
			return CKL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateCK(CKinfo CK) {

		try {
			pstmt = conn
					.prepareStatement("update CK set CK_NO = ?, CK_NAME = ?, "
							+ "CK_QUANTITY = ?, CK_CONTENT = ?, CK_USER = ?, CK_DATE = ?	where CK_ID = ?");
			pstmt.setString(1, CK.getno());
			pstmt.setString(2, CK.getname());
			pstmt.setInt(3, CK.getquantity());
			pstmt.setString(4, CK.getcontent());
			pstmt.setString(5, CK.getuser());
			pstmt.setString(6, CK.getdate());
			
			pstmt.setInt(7, CK.getid());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteCK(int id) {

		try {
			pstmt = conn.prepareStatement("delete from CK where CK_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table CK drop CK_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table CK add CK_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(CK_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
	public CKinfo queryCKbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from CK where CK_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				CKinfo CK = new CKinfo();
				CK.setid(rs.getInt(7));
				CK.setno(rs.getString(1));
				CK.setname(rs.getString(2));
				CK.setquantity(rs.getInt(3));
				CK.setcontent(rs.getString(4));
				CK.setuser(rs.getString(5));
				CK.setdate(rs.getString(6));
				return CK;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
}
