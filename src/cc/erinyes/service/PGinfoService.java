package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.PGinfo;

public class PGinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public PGinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addPG(PGinfo PG) {
		try {
			pstmt = conn.prepareStatement("insert into PG"
					+ "(PG_CONPANY, PG_BEGIN, PG_END, PG_NAME, PG_NRIRONG) "
					+ "values(?,?,?,?,?)");
			pstmt.setString(1, PG.getcompany());
			pstmt.setString(2, PG.getbegin());
			pstmt.setString(3, PG.getend());
			pstmt.setString(4, PG.getname());
			pstmt.setString(5, PG.getneirong());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllPG() {
		List PGL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from PG");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PGinfo PG = new PGinfo();
				PG.setid(rs.getInt(1));
				PG.setcompany(rs.getString(2));
				PG.setbegin(rs.getString(3));
				PG.setend(rs.getString(4));
				PG.setname(rs.getString(5));
				PG.setneirong(rs.getString(6));
				PGL.add(PG);
			}
			return PGL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(PGinfo PG) {

		try {
			pstmt = conn
					.prepareStatement("update PG set PG_COMPANY = ?, PG_BEGIN = ?, "
							+ "PG_END = ?, PG_NAME = ?, PG_NEIRONG = ?	where PG_ID = ?");
			pstmt.setString(1, PG.getcompany());
			pstmt.setString(2, PG.getbegin());
			pstmt.setString(3, PG.getend());
			pstmt.setString(4, PG.getname());
			pstmt.setString(5, PG.getneirong());
			pstmt.setInt(6, PG.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deletePG(int id) {

		try {
			pstmt = conn.prepareStatement("delete from PG where PG_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
