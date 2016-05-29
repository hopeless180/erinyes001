package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					+ "(id,name,quantity,cost,total,content,creator,status) "
					+ "values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, DD.getid());
			pstmt.setString(2, DD.getname());
			pstmt.setInt(3, DD.getquantity());
			pstmt.setDouble(4, DD.getcost());
			pstmt.setDouble(5, DD.gettotal());
			pstmt.setString(6, DD.getcontent());
			pstmt.setString(7, DD.getcreator());
			pstmt.setString(8, DD.getstatus());

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
				DD.setid(rs.getInt(1));
				DD.setname(rs.getString(2));
				DD.setcreator(rs.getString(3));
				DD.setquantity(rs.getInt(4));
				DD.setcost(rs.getDouble(5));
				DD.settotal(rs.getDouble(6));
				DD.setstatus(rs.getString(7));
				DD.setcontent(rs.getString(8));
				DDL.add(DD);
			}
			return DDL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(DDinfo DD) {

		try {
			pstmt = conn
					.prepareStatement("update DD set DD_NAME=? , DD_CREATOR=? ,DD_QUANTITY=? ,"
							+ "DD_COST=? , DD_TOTAL=?, DD_STATUS=?, DD_CONTENT=?    where id=?");
			pstmt.setString(1, DD.getname());
			pstmt.setString(2, DD.getcreator());
			pstmt.setInt(3, DD.getquantity());
			pstmt.setDouble(4, DD.getcost());
			pstmt.setDouble(5, DD.gettotal());
			pstmt.setString(6, DD.getstatus());
			pstmt.setString(7, DD.getcontent());
			pstmt.setInt(9, DD.getid());
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
			pstmt = conn.prepareStatement("delete from DD where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
