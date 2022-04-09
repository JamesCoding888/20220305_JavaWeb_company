package Dao;

public interface implMember {
	// Create
	public void addMember(Object o);
	
	// Read
	public boolean query(String username, String password); // 帳號密碼
	public boolean query(String username); // 帳號重複
	
	// Update
	
	
	// Delete
}
