package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.CauThu;
import entity.ViTriThiDau;

public class CauThu_DAO {
	public CauThu_DAO() {
		
	}
	
	public ArrayList<CauThu> getalltbCauThu(){
		ArrayList<CauThu> dsct = new ArrayList<CauThu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select *from CauThu";
			Statement statement = con.createStatement();
			
			//Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			
			//Duyệt trên kết quả trả về
			while(rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
				String maCauThu = rs.getString("Mã cầu thủ");
				String tenCauThu = rs.getString("Tên cầu thủ");
				int tuoi = rs.getInt("Tuổi");
				ViTriThiDau vtri = new ViTriThiDau(rs.getString("Mã vị trí"));
				
				CauThu ct = new CauThu(maCauThu, tenCauThu, tuoi, vtri);
				dsct.add(ct);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsct;
		
	}
	 public ArrayList<CauThu> getCauThuTheoMaCT(String id){
		 ArrayList<CauThu> dsct = new ArrayList<CauThu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select *from CauThu where maCauThu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			
			//Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//Duyệt trên kết quả trả về
			while(rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
				String maCauThu = rs.getString("Mã cầu thủ");
				String tenCauThu = rs.getString("Tên cầu thủ");
				int tuoi = rs.getInt("Tuổi");
				ViTriThiDau vtri = new ViTriThiDau(rs.getString("Mã vị trí"));
				
				CauThu ct = new CauThu(maCauThu, tenCauThu, tuoi, vtri);
				dsct.add(ct);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dsct;
	 }
	 
	 public ArrayList<CauThu> getCauThuTheoViTriThiDau(String idVtri){
		 ArrayList<CauThu> dsct  = new ArrayList<CauThu>();
		 ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		 PreparedStatement statement = null;
		 try {
			String sql = "Select *from CauThu where maViTri = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1,idVtri);
			//Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//Duyệt trên kết quả trả về
			while(rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
				String maCauThu = rs.getString("Mã cầu thủ");
				String tenCauThu = rs.getString("Tên cầu thủ");
				int tuoi = rs.getInt("Tuổi");
				ViTriThiDau vtri = new ViTriThiDau(rs.getString("Mã vị trí"));
				
				CauThu ct = new CauThu(maCauThu, tenCauThu,  tuoi, vtri);
				dsct.add(ct);
		}
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dsct;
		 
	 }
	 
	 public boolean create(CauThu ct) {
		 ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		 PreparedStatement stmt = null;
		 int n = 0;
		 try {
			stmt = con.prepareStatement("insert into" + "CauThu value(?, ?, ?, ?)");
			stmt.setString(1, ct.getMaSoCauThu());
			stmt.setString(2, ct.getTenCauThu());
			stmt.setInt(3, ct.getTuoi());
			stmt.setString(4, ct.getVtri().getMaViTri());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	 }
	
}
