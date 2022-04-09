package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.member;
public class memberDao implements implMember {
	public static void main(String[] args) {
		// Create
		/*
		member m = new member("東華","1234","j","123","123","123");
		new memberDao().addMember(m);
		*/
		// Read
		System.out.println(new memberDao().query("東華", "1234"));
		System.out.println(new memberDao().query("東華"));
	}
	
	
	@Override
	public void addMember(Object o) {
		Connection conn = DbConnection.getDb();
		member m = (member)o;
		String sql = "insert into member(username, password, name, address, phone, mobile)"
					+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMobile());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean query(String username, String password) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from company_20220409.member where username=? and password=?";
		boolean isAccountReady = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){ // 確認是否 帳號和密碼 都存在
				isAccountReady = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAccountReady;
	}

	@Override
	public boolean query(String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from company_20220409.member where username=? ";
		boolean isAccountReady = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);						
			ResultSet rs = ps.executeQuery();
			if(rs.next()){ // 確認是否 帳號 存在
				isAccountReady = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAccountReady;
	}		
}
