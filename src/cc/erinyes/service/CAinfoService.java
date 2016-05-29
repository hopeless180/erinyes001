package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.CAinfo;

public class CAinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public CAinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addCA(CAinfo CA) {
		try {
			pstmt = conn.prepareStatement("insert into CA"
					+ "(CA_ITEM, CA_NAME, CA_ANALYST, CA_DATE, CA_CONCLUSION) "
					+ "values(?,?,?,?,?)");
			pstmt.setString(1, CA.getitem());
			pstmt.setString(2, CA.getname());
			pstmt.setString(3, CA.getanalyst());
			pstmt.setString(4, CA.getdate());
			pstmt.setString(5, CA.getconclusion());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllCA() {
		List CAL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from CA");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CAinfo CA = new CAinfo();
				CA.setid(rs.getInt(1));
				CA.setitem(rs.getString(2));
				CA.setname(rs.getString(3));
				CA.setanalyst(rs.getString(4));
				CA.setdate(rs.getString(5));
				CA.setconclusion(rs.getString(6));
				CAL.add(CA);
			}
			return CAL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(CAinfo CA) {

		try {
			pstmt = conn
					.prepareStatement("update CA set CA_ITEM = ?, CA_NAME = ?, CA_ANALYST = ?, CA_DATE = ?, CA_CONCLUSION = ?	where CA_ID = ?");
			pstmt.setString(1, CA.getitem());
			pstmt.setString(2, CA.getname());
			pstmt.setString(3, CA.getanalyst());
			pstmt.setString(4, CA.getdate());
			pstmt.setString(5, CA.getconclusion());
			pstmt.setInt(6, CA.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteCA(int id) {

		try {
			pstmt = conn.prepareStatement("delete from CA where CA_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
