import java.sql.*;

public class Insert {
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_teaching", "root", "edward");
			
//			String sql = "INSERT INTO jdbc_teaching ( user_name,password) VALUES ('alex','123')";
//			String sql = "DELETE FROM jdbc_teaching.jdbc_teaching WHERE user_name = 'chen'";
//			String sql = "SELECT * FROM jdbc_teaching";
//			String sql = "INSERT INTO `tcis-update`.`gtech` (`name`, `online`, `mac`, `ip`, `ftp_server`, `ftp_port`, `ftp_username`, " +
//					"`ftp_password`, `ftp_foldername`, `ftp_update`) VALUES ('liftcore2', 'true', '22:33:44:55:66:77', '192.168.1.163'," +
//					" '198.168.1.178', '21', 'jane', 'janee', 'tcis_ftp', 'true')";
			//update name liftcore23 to liftcore234
//			String sql2 = "UPDATE  `tcis-update`.`gtech` SET  `name` =  'liftcore234' WHERE  `gtech`.`name` =  'liftcore23'";
			String sql3 = "SELECT * FROM jdbc_teaching WHERE user_name='tc1'";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql3);
//			stmt.execute(sql3);

			if (!rs.next())
			{
				System.out.println("table was not exist,need to create one");
				String sql = "INSERT INTO jdbc_teaching (user_name,password) VALUES ('tc1','')";
				stmt.execute(sql);
			}
				while (true)
				{
					String sql4 = "SELECT * FROM jdbc_teaching WHERE user_name='tc1'";
					ResultSet rs2 = stmt.executeQuery(sql4);
					if (rs2.next())
					{
//						System.out.println(rs2.getString("user_name"));
						if (rs2.getString("password").equals("true"))
						{
							System.out.println("ftp need update ");
							break;
						}
						Thread.sleep(2000);
					}
						
				}
//				String userName = rs.getString("user_name");
//				String userPassword = rs.getString(2);
//				System.out.println(userName + ":" + userPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
