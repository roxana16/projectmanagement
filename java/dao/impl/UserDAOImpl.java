package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDAO;
import entities.User;
import utils.ConnectionFactory;

public class UserDAOImpl implements UserDAO{

	@Override
	public User getById(Integer id) {
		Connection connection = ConnectionFactory.getConnection();
		User user = null;

		String query = "SELECT * FROM user WHERE userId = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = extractUser(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Could not select user with id " + id + ": " + ex.getMessage());
		} 
		
		return user;
	}

	@Override
	public User getByUsername(String username) {
		Connection connection = ConnectionFactory.getConnection();
		User user = null;

		String query = "SELECT * FROM user WHERE userName = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1,username);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = extractUser(resultSet);
			}
		} catch (SQLException ex) {
			System.out.println("Could not select user with username " + username + ": " + ex.getMessage());
		} 
		
		return user;
	}

	@Override
	public Integer insertUser(User user) {
		
		Connection connection = ConnectionFactory.getConnection();
		Integer id = null;

		String query = "INSERT INTO user (userId, userName, firstName, lastName, email, userPass, isAdmin) values(null, ?, ?, ?, ?, ?,?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3,user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setBoolean(6, user.isAdmin());
	

			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
		} catch (SQLException ex) {
			System.out.println("Could not insert user:" + user);
		} 
		
		return id;
	}

	@Override
	public boolean updateUser(User user) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		String query = "UPDATE user SET userName = ?, firstName = ?, lastName = ?, email = ?, userPass = ?,"
				+ "isAdmin = ? WHERE userId = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5,user.getPassword());
			preparedStatement.setBoolean(6, user.isAdmin());
	

			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Could not update user with id " + user.getId() + ": " + ex.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(Integer id) {

		Connection connection = ConnectionFactory.getConnection();
		
		String query = "DELETE FROM user WHERE userId = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setInt(1, id);

			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Could not delete user with id " + id + ": " + ex.getMessage());
		}
		
		return false;
	}
	
	private User extractUser(final ResultSet resultSet) throws SQLException {
		User user = new User(resultSet.getInt("userId"),
			resultSet.getString("userName"),
			resultSet.getString("firstName"),
			resultSet.getString("lastName"),
			resultSet.getString("email"),
			resultSet.getString("userPass"),
			resultSet.getBoolean("isAdmin"));
			
		return user;
	}
}
