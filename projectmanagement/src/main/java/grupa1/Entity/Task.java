package grupa1.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
public class Task {

    @Id
    @Column(name = "taskId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @Basic
    @Column(name = "taskContent", nullable = true, length = 2100)
    private String taskContent;

    @Basic
    @Column(name = "taskName", nullable = false, length = 100)
    private String taskName;

    @Basic
    @Column(name = "startTime", nullable = true)
    private Timestamp startTime;

    @Basic
    @Column(name = "remainingHours", nullable = true)
    private Integer remainingHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;


    public Task() {}

    public Task(String taskName, String taskContent, Timestamp startTime, Integer remainingHours) {
        this.taskContent = taskContent;
        this.taskName = taskName;
        this.startTime = startTime;
        this.remainingHours = remainingHours;
    }

    public Task(String taskName, String taskContent, Integer remainingHours) {
        this(taskContent, taskName, new Timestamp(System.currentTimeMillis()), remainingHours);
    }

    public Task(String taskName, String taskContent) {
        this(taskName, taskContent, 48);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setTask(this);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTaskId() {
        return taskId;
    }

    private void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }


    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Integer getRemainingHours() {
        return remainingHours;
    }

    public void setRemainingHours(Integer remainingHours) {
        this.remainingHours = remainingHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != null ? !taskId.equals(task.taskId) : task.taskId != null) return false;
        if (taskContent != null ? !taskContent.equals(task.taskContent) : task.taskContent != null) return false;
        if (taskName != null ? !taskName.equals(task.taskName) : task.taskName != null) return false;
        if (startTime != null ? !startTime.equals(task.startTime) : task.startTime != null) return false;
        if (remainingHours != null ? !remainingHours.equals(task.remainingHours) : task.remainingHours != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (remainingHours != null ? remainingHours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskContent='" + taskContent + '\'' +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", remainingHours=" + remainingHours +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
