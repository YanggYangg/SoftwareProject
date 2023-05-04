/**
 * STT16_Nguyễn Thị Quỳnh Giang_21034451_DHKTPM17B
 */
package tuanOnTap_16_qlyVDV_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tuanOnTap_16_qlyVDV_ConnectDB.ConnectDB;
import tuanOnTap_16_qlyVDV_entity.CauLacBo;

public class CauLacBo_DAO {
	public CauLacBo_DAO() {
		
	}
	
	public ArrayList<CauLacBo> getalltbCLB(){
		ArrayList<CauLacBo> dsclb = new ArrayList<CauLacBo>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select *from CauLacBo";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maCLB = rs.getString(1);
				String tenCLB = rs.getString("TenCLB");
				CauLacBo clb = new CauLacBo(maCLB, tenCLB);
				dsclb.add(clb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsclb;
		
	}

}
