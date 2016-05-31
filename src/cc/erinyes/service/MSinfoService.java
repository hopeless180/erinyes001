package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.KCinfo;
import cc.erinyes.model.MSinfo;

public class MSinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public MSinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addMS(MSinfo MS) {
		try {
			pstmt = conn.prepareStatement("insert into MS"
					+ "(MS_REPOSITORY, MS_MID, MS_DATE, MS_NAME, MS_QUANTITY) "
					+ "values(?,?,?,?,?)");
			pstmt.setString(1, MS.getrepository());
			pstmt.setInt(2, MS.getmid());
			pstmt.setString(3, MS.getdate());
			pstmt.setString(4, MS.getname());
			pstmt.setInt(5, MS.getquantity());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllMS() {
		List MSL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from MS");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MSinfo MS = new MSinfo();
				MS.setid(rs.getInt(6));
				MS.setrepository(rs.getString(1));
				MS.setmid(rs.getInt(2));
				MS.setdate(rs.getString(3));
				MS.setname(rs.getString(4));
				MS.setquantity(rs.getInt(5));
				MSL.add(MS);
			}
			return MSL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public MSinfo queryMSbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from MS where MS_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				MSinfo MS = new MSinfo();
				MS.setid(rs.getInt(6));
				MS.setrepository(rs.getString(1));
				MS.setmid(rs.getInt(2));
				MS.setdate(rs.getString(3));
				MS.setname(rs.getString(4));
				MS.setquantity(rs.getInt(5));
				return MS;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateMS(MSinfo MS) {

		try {
			pstmt = conn
					.prepareStatement("update MS set MS_REPOSITORY = ?, MS_MID = ?, "
							+ "MS_DATE = ?, MS_NAME = ?, MS_QUANTITY = ?	where MS_ID = ?");
			pstmt.setString(1, MS.getrepository());
			pstmt.setInt(2, MS.getmid());
			pstmt.setString(3, MS.getdate());
			pstmt.setString(4, MS.getname());
			pstmt.setInt(5, MS.getquantity());
			
			pstmt.setInt(6, MS.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteMS(int id) {

		try {
			pstmt = conn.prepareStatement("delete from MS where MS_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table MS drop MS_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table MS add MS_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(MS_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}

