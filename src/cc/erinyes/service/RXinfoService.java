package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.RXinfo;

public class RXinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public RXinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addRX(RXinfo RX) {
		try {
			pstmt = conn.prepareStatement("insert into RX"
					+ "(RX_NAME, RX_LOCATION, RX_STATUS) "
					+ "values(?,?,?)");
			pstmt.setString(1, RX.getname());
			pstmt.setString(2, RX.getlocation());
			pstmt.setString(3, RX.getstatus());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllRX() {
		List RXL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from RX");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RXinfo RX = new RXinfo();
				RX.setid(rs.getInt(1));
				RX.setname(rs.getString(2));
				RX.setlocation(rs.getString(3));
				RX.setstatus(rs.getString(4));
				
				RXL.add(RX);
			}
			return RXL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(RXinfo RX) {

		try {
			pstmt = conn
					.prepareStatement("update RX set RX_NAME = ?, RX_LOCATION = ?, "
							+ "RX_STATUS = ?	where RX_ID = ?");
			pstmt.setString(1, RX.getname());
			pstmt.setString(2, RX.getlocation());
			pstmt.setString(3, RX.getstatus());
			
			pstmt.setInt(4, RX.getid());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteRX(int id) {

		try {
			pstmt = conn.prepareStatement("delete from RX where RX_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
