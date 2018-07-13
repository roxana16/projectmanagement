package grupa1.persistence;

import grupa1.Entity.User;

public interface DataProvider {

    public Integer addUser(User user);
    public User getUserByUsername(String username);
}
