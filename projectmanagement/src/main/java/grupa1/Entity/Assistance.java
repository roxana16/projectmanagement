package grupa1.Entity;

import javax.persistence.*;
import java.util.Objects;



@Entity
public class Assistance {


    @Id
    @Column(name = "assistanceId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer assistanceId;

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
    @Column(name = "subject")
    private String subject;

    public Assistance() {}

    public Assistance(String firstName, String lastName, String email, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subject = subject;
    }

    public Integer getAssistanceId() {
        return assistanceId;
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

    public String getSubject() {
        return email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assistance assist = (Assistance) o;
        return Objects.equals(assistanceId, assist.assistanceId) &&
                Objects.equals(firstName, assist.firstName) &&
                Objects.equals(lastName, assist.lastName) &&
                Objects.equals(email, assist.email) &&
                Objects.equals(subject, assist.subject);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(assistanceId, firstName, lastName, email, subject);
        return result;
    }

    @Override
    public String toString() {
        return "Assistance{" +
                "assistanceId=" + assistanceId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
