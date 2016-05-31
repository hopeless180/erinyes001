package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.EHinfo;
import cc.erinyes.model.ERRinfo;

public class ERRinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public ERRinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addERR(ERRinfo ERR) {
		try {
			pstmt = conn.prepareStatement("insert into ERR"
					+ "(ERR_FINDER, ERR_NAME, ERR_DATE, ERR_INFO, ERR_STATUS) "
					+ "values(?,?,?,?,?)");
			pstmt.setString(1, ERR.getfinder());
			pstmt.setString(2, ERR.getname());
			pstmt.setString(3, ERR.getdate());
			pstmt.setString(4, ERR.getinfo());
			pstmt.setString(5, ERR.getstatus());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllERR() {
		List ERRL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from ERR");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ERRinfo ERR = new ERRinfo();
				ERR.setid(rs.getInt(6));
				ERR.setfinder(rs.getString(1));
				ERR.setname(rs.getString(2));
				ERR.setdate(rs.getString(3));
				ERR.setinfo(rs.getString(4));
				ERR.setstatus(rs.getString(5));
				ERRL.add(ERR);
			}
			return ERRL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public ERRinfo queryERRbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from ERR where ERR_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ERRinfo ERR = new ERRinfo();
				ERR.setid(rs.getInt(6));
				ERR.setfinder(rs.getString(1));
				ERR.setname(rs.getString(2));
				ERR.setdate(rs.getString(3));
				ERR.setinfo(rs.getString(4));
				ERR.setstatus(rs.getString(5));
				return ERR;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateERR(ERRinfo ERR) {

		try {
			pstmt = conn
					.prepareStatement("update ERR set ERR_FINDER = ?, ERR_NAME = ?, "
							+ "ERR_DATE = ?, ERR_INFO= ?, ERR_STATUS = ?	where ERR_ID = ?");
			pstmt.setString(1, ERR.getfinder());
			pstmt.setString(2, ERR.getname());
			pstmt.setString(3, ERR.getdate());
			pstmt.setString(4, ERR.getinfo());
			pstmt.setString(5, ERR.getstatus());
			
			pstmt.setInt(6, ERR.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteERR(int id) {

		try {
			pstmt = conn.prepareStatement("delete from ERR where ERR_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table ERR drop ERR_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table ERR add ERR_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(ERR_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
