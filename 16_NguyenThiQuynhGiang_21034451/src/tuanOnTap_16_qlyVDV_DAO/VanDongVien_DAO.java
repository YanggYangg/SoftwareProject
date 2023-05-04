package tuanOnTap_16_qlyVDV_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tuanOnTap_16_qlyVDV_ConnectDB.ConnectDB;
import tuanOnTap_16_qlyVDV_entity.CauLacBo;
import tuanOnTap_16_qlyVDV_entity.VanDongVien;

public class VanDongVien_DAO {
	public VanDongVien_DAO() {
		
	}
	
	public ArrayList<VanDongVien> getalltbVDV(){
		ArrayList<VanDongVien> dsvdv = new ArrayList<VanDongVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select *from VanDongVien";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maVDV = rs.getString(1);
				String tenVDV = rs.getString(2);
				int tuoi = rs.getInt(3);
				CauLacBo clb = new CauLacBo(rs.getString("maCLB"));
				
				VanDongVien vdv = new VanDongVien(maVDV, tenVDV, tuoi, clb);
				dsvdv.add(vdv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsvdv;
	}
	
	public ArrayList<VanDongVien> getVDVtheoCLB(String idCLB){
		ArrayList<VanDongVien> dsvdv = new ArrayList<VanDongVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = " Select *from VanDongVien where MaCLB= ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, idCLB);
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maVDV = rs.getString(1);
				String tenVDV = rs.getString(2);
				int tuoi = rs.getInt(3);
				CauLacBo clb = new CauLacBo(rs.getString("maCLB"));
				
				VanDongVien vdv = new VanDongVien(maVDV, tenVDV, tuoi, clb);
				dsvdv.add(vdv);
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
		return dsvdv;
	}
	
	public boolean createVDV(VanDongVien vdv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		
		try {
			stmt = con.prepareStatement("insert into" + "VanDongVien values (?, ?, ?, ?)");
			stmt.setString(1, vdv.getMaVDV());
			stmt.setString(2, vdv.getTenVDV());
			stmt.setInt(3, vdv.getTuoi());
			stmt.setString(4, vdv.getClb().getMaCLB());
		}catch(SQLException e) {
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
	
	public boolean deleteVDV(VanDongVien vdv) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Delete from VanDongVien where MaVDV= ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setString(1, vdv.getMaVDV());
			
			return !pstm.execute();
		}catch(Exception e) {
			return false;
		}
	}
}
