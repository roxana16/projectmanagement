package dao;

import entities.User;

public interface UserDAO {
	
	public User getById(Integer id);
	
	public User getByUsername(String username);
	
	public Integer insertUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(Integer id);
}
