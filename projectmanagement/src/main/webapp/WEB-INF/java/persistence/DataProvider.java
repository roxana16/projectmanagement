package persistence;

import Entity.User;
import com.google.common.collect.Iterables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public interface DataProvider {

    public int addUser(User user);
    public User getUserByUsername(String username);
}
