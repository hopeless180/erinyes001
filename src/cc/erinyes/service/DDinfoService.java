package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cc.erinyes.model.CKinfo;
import cc.erinyes.model.DDinfo;

public class DDinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public DDinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addDD(DDinfo DD) {
		try {
			pstmt = conn.prepareStatement("insert into DD"
					+ "(DD_NAME, DD_QUANTITY, DD_COST, DD_TOTAL, DD_CONTENT, DD_CREATOR , DD_STATUS) "
					+ "values(?,?,?,?,?,?,?)");
			pstmt.setString(1, DD.getname());
			pstmt.setInt(2, DD.getquantity());
			pstmt.setDouble(3, DD.getcost());
			pstmt.setDouble(4, DD.gettotal());
			pstmt.setString(5, DD.getcontent());
			pstmt.setString(6, DD.getcreator());
			pstmt.setString(7, DD.getstatus());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllDD() {
		List DDL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from DD");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				DDinfo DD = new DDinfo();
				DD.setname(rs.getString(1));
				DD.setcreator(rs.getString(2));
				DD.setquantity(rs.getInt(3));
				DD.setcost(rs.getDouble(4));
				DD.settotal(rs.getDouble(5));
				DD.setstatus(rs.getString(6));
				DD.setcontent(rs.getString(7));
				DD.setid(rs.getInt(8));
				DDL.add(DD);
			}
			return DDL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateDD(DDinfo DD) {

		try {
			pstmt = conn
					.prepareStatement("update DD set DD_NAME=? , DD_CREATOR=? ,DD_QUANTITY=? ,"
							+ "DD_COST=? , DD_TOTAL=?, DD_STATUS=?, DD_CONTENT=?    where DD_ID=?");
			pstmt.setString(1, DD.getname());
			pstmt.setString(2, DD.getcreator());
			pstmt.setInt(3, DD.getquantity());
			pstmt.setDouble(4, DD.getcost());
			pstmt.setDouble(5, DD.gettotal());
			pstmt.setString(6, DD.getstatus());
			pstmt.setString(7, DD.getcontent());
			pstmt.setInt(8, DD.getid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteDD(int id) {

		try {
			pstmt = conn.prepareStatement("delete from DD where DD_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table DD drop DD_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table DD add DD_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(DD_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
	public DDinfo queryDDbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from DD where DD_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				DDinfo DD = new DDinfo();
				DD.setname(rs.getString(1));
				DD.setcreator(rs.getString(2));
				DD.setquantity(rs.getInt(3));
				DD.setcost(rs.getDouble(4));
				DD.settotal(rs.getDouble(5));
				DD.setstatus(rs.getString(6));
				DD.setcontent(rs.getString(7));
				DD.setid(rs.getInt(8));
				return DD;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
