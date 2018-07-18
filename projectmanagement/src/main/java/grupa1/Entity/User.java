package grupa1.Entity;

import org.bouncycastle.crypto.generators.SCrypt;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



@Entity
public class User {


    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;

    @Basic
    @Column(name = "userName")
    private String userName;

    @Basic
    @Column(name = "firstName")
    private String firstName;

    @Basic
    @Column(name = "lastName")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "passwordHash")
    private byte[] passwordHash;

    @Basic
    @Column(name = "hashSalt")
    private byte[] hashSalt;

    @Basic
    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<Task> tasks = new ArrayList<>();

    public User() {}

    public User(String userName, String firstName, String lastName, String email, String userPass) {
        this(userName, firstName, lastName, email, userPass, false);
    }

    public User(String userName, String firstName, String lastName, String email, String userPass, Boolean isAdmin) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        setPassword(userPass);
        this.isAdmin = isAdmin;
    }

    public void assignTask(Task task) {
        tasks.add(task);
        task.setUser(this);
    }

    public boolean hasPassword(String password) {

        byte[] hash = SCrypt.generate(password.getBytes(), hashSalt, 32768, 8, 1, 64);
        return Arrays.equals(hash, passwordHash);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getUserId() {
        return userId;
    }

    private void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        byte[] hash = SCrypt.generate(password.getBytes(), salt, 32768, 8, 1, 64);

        this.passwordHash = hash;
        this.hashSalt = salt;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(passwordHash, user.passwordHash) &&
                Arrays.equals(hashSalt, user.hashSalt) &&
                Objects.equals(isAdmin, user.isAdmin) &&
                Objects.equals(tasks, user.tasks);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(userId, userName, firstName, lastName, email, isAdmin, tasks);
        result = 31 * result + Arrays.hashCode(passwordHash);
        result = 31 * result + Arrays.hashCode(hashSalt);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash=" + Arrays.toString(passwordHash) +
                ", hashSalt=" + Arrays.toString(hashSalt) +
                ", isAdmin=" + isAdmin +
                ", tasks=" + tasks +
                '}';
    }
}
