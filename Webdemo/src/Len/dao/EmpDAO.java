package Len.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//�g�i��Ʈw
public class EmpDAO {
	public void insert(String lastName, String firstName, Date birthDate) {
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into employees(lastName,firstName,birthDate)value(?,?,?)");
			ps.setString(1, lastName);
			ps.setString(2, firstName);
			ps.setDate(3, birthDate);
			ps.execute();
			//�}�ҤW��
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//�����W��
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			helper.closeConn(conn);
		}
	}

	// �d�ߩҦ����
	public List<String[]> selectAll() {
		List<String[]> list = new ArrayList<String[]>();
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select employeeid ,lastName,firstName,birthDate from employees");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				String[] emp = new String[4];
				emp[0] = result.getString("employeeid");
				emp[1] = result.getString("lastName");
				emp[2] = result.getString("firstName");
				Date date = result.getDate("birthdate");
				//Date����ഫ��String
				DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
				String dateStr = df.format(date);
				//Date�নString��ƶǦ^�}�C
				emp[3] = dateStr;
				//��}�C��Ʀ^�Ǩ�LIST
				list.add(emp);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			helper.closeConn(conn);

		}
		return list;

	}
}
