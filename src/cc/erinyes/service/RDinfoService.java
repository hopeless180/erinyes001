package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.RDinfo;

public class RDinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public RDinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addRD(RDinfo RD) {
		try {
			pstmt = conn.prepareStatement("insert into RD"
					+ "(RD_DATE, RD_BEGIN, RD_END, RD_YGNAME, RD_ITEM, RD_LOCATION) "
					+ "values(?,?,?,?,?,?)");
			pstmt.setString(1, RD.getdate());
			pstmt.setString(2, RD.getbegin());
			pstmt.setString(3, RD.getend());
			pstmt.setString(4, RD.getygname());
			pstmt.setString(5, RD.getitem());
			pstmt.setString(6, RD.getlocation());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllRD() {
		List RDL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from RD");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RDinfo RD = new RDinfo();
				RD.setid(rs.getInt(1));
				RD.setdate(rs.getString(2));
				RD.setbegin(rs.getString(3));
				RD.setend(rs.getString(4));
				RD.setygname(rs.getString(5));
				RD.setitem(rs.getString(6));
				RD.setlocation(rs.getString(7));
				RDL.add(RD);
			}
			return RDL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(RDinfo RD) {

		try {
			pstmt = conn
					.prepareStatement("update RD set RD_DATE = ?, RD_BEGIN = ?, "
							+ "RD_END = ?, RD_YGNAME = ?, RD_ITEM = ?, RD_LOCATION = ?	where RD_ID = ?");
			pstmt.setString(1, RD.getdate());
			pstmt.setString(2, RD.getbegin());
			pstmt.setString(3, RD.getend());
			pstmt.setString(4, RD.getygname());
			pstmt.setString(5, RD.getitem());
			pstmt.setString(6, RD.getlocation());
			
			pstmt.setInt(7, RD.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteRD(int id) {

		try {
			pstmt = conn.prepareStatement("delete from RD where RD_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
