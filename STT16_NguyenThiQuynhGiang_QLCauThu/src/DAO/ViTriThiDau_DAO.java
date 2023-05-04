package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.ConnectDB;
import entity.ViTriThiDau;

public class ViTriThiDau_DAO {
	public ArrayList<ViTriThiDau> getalltbVtri(){
		ArrayList<ViTriThiDau> dsVtri = new ArrayList<ViTriThiDau>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select *from ViTriThiDau";
			Statement statement = con.createStatement();
			//Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//Duyệt trên kết quả trả về
			while(rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
				String maVtri = rs.getString(1);
				String tenVtri = rs.getString("Tên Vị Trí");
				ViTriThiDau vt = new ViTriThiDau(maVtri, tenVtri);
				dsVtri.add(vt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVtri;
	}
}
