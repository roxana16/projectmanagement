package grupa1.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @Column(name = "userPass")
    private String userPass;

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
        this.userPass = userPass;
        this.isAdmin = isAdmin;
    }

    public void assignTask(Task task) {
        tasks.add(task);
        task.setUser(this);
    }

    public boolean hasPassword(String password) {
        return userPass.equals(password);
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

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
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

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userPass != null ? !userPass.equals(user.userPass) : user.userPass != null) return false;
        if (isAdmin != null ? !isAdmin.equals(user.isAdmin) : user.isAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
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
                ", userPass='" + userPass + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
