package cc.erinyes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cc.erinyes.model.DDinfo;
import cc.erinyes.model.EHinfo;
import sun.security.timestamp.TSRequest;

public class EHinfoService {
	private Connection conn;
	private PreparedStatement pstmt;

	public EHinfoService() {
		// TODO Auto-generated constructor stub
		conn = new cc.erinyes.conn.conn().getCon();
	}
	
	public boolean addEH(EHinfo EH) {
		try {
			pstmt = conn.prepareStatement("insert into EH"
					+ "(EH_HANDLER, EH_ERRID, EH_DATE, EH_INFO) "
					+ "values(?,?,?,?)");
			pstmt.setString(1, EH.gethandler());
			pstmt.setInt(2, EH.geterrid());
			pstmt.setString(3, EH.getdate());
			pstmt.setString(4, EH.getinfo());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List queryAllEH() {
		List EHL = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from EH");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EHinfo EH = new EHinfo();
				EH.setid(rs.getInt(5));
				EH.sethandler(rs.getString(1));
				EH.seterrid(rs.getInt(2));
				EH.setdate(rs.getString(3));
				EH.setinfo(rs.getString(4));

				EHL.add(EH);
			}
			return EHL;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateEH(EHinfo EH) {

		try {
			pstmt = conn
					.prepareStatement("update EH set EH_HANDLER = ?, EH_ERRID = ?, "
							+ "EH_DATE = ?, EH_INFO = ?	where EH_ID = ?");
			pstmt.setString(1, EH.gethandler());
			pstmt.setInt(2, EH.geterrid());
			pstmt.setString(3, EH.getdate());
			pstmt.setString(4, EH.getinfo());

			pstmt.setInt(5, EH.getid());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deleteEH(int id) {

		try {
			pstmt = conn.prepareStatement("delete from EH where EH_ID=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table EH drop EH_ID");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("alter table EH add EH_ID int NOT NULL AUTO_INCREMENT, add PRIMARY KEY(EH_ID)");
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
	
	public EHinfo queryEHbyID(int id) {
		try {
			pstmt = conn
					.prepareStatement("select * from EH where EH_ID=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				EHinfo EH = new EHinfo();
				EH.setid(rs.getInt(5));
				EH.sethandler(rs.getString(1));
				EH.seterrid(rs.getInt(2));
				EH.setdate(rs.getString(3));
				EH.setinfo(rs.getString(4));
				return EH;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
