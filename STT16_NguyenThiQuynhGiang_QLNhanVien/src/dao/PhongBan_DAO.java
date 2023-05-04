package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getalltbPhongBan(){
		ArrayList<PhongBan> dsphongban = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select *from PhongBan";
			Statement statement = con.createStatement();
			//Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//Duyệt trên kết quả trả về
			while(rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPB = rs.getString(1);
				String tenPB = rs.getString("tenPhong");
				PhongBan p = new PhongBan(maPB, tenPB);
				dsphongban.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsphongban;
		
	}
}
