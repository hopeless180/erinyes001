package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.GXinfo;

public class GXinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public GXinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addGX(GXinfo GX) {
		try {
			pstmt = conn.prepareStatement("insert into GX"
					+ "(GX_NAME, GX_INFO) "
					+ "values(?,?)");
			pstmt.setString(1, GX.getname());
			pstmt.setString(2, GX.getinfo());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllGX() {
		List GXL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from GX");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				GXinfo GX = new GXinfo();
				GX.setid(rs.getInt(1));
				GX.setname(rs.getString(2));
				GX.setinfo(rs.getString(3));
				GXL.add(GX);
			}
			return GXL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(GXinfo GX) {

		try {
			pstmt = conn
					.prepareStatement("update GX set GX_NAME = ?,GX_INFO = ?	where GX_ID = ?");
			pstmt.setString(1, GX.getname());
			pstmt.setString(2, GX.getinfo());
			
			pstmt.setInt(3, GX.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteGX(int id) {

		try {
			pstmt = conn.prepareStatement("delete from GX where GX_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
