package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.porder;

public class porderDao implements implPorder {

	public static void main(String[] args) {
		porder p = new porder("B桌", 1, 2, 3);
		new porderDao().add(p);
	}
	
	@Override
	public void add(Object o) {
		Connection conn = DbConnection.getDb();
		String sql ="insert into porder(desk, A, B, C, sum) values(?, ?, ?, ?, ?)";		
		porder p = (porder)o;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
