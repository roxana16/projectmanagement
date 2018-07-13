package persistence;

import Entity.User;

public interface DataProvider {

    public Integer addUser(User user);
    public User getUserByUsername(String username);
}
