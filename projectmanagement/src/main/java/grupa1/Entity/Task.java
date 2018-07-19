package grupa1.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    private Integer estimatedHoursNeeded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    //this is a really bad idea, but it makes my life easy
    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    @OrderBy("timeMade DESC")
    private List<Comment> comments;


    public Task() {}

    public Task(String taskName, String taskContent, Timestamp startTime, Integer estimatedHoursNeeded) {
        this.taskContent = taskContent;
        this.taskName = taskName;
        this.startTime = startTime;
        this.estimatedHoursNeeded = estimatedHoursNeeded;
    }

    public Task(String taskName, String taskContent, Integer estimatedHoursNeeded) {
        this(taskName, taskContent, new Timestamp(System.currentTimeMillis()), estimatedHoursNeeded);
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

    public Integer getEstimatedHoursNeeded() {
        return estimatedHoursNeeded;
    }

    public void setEstimatedHoursNeeded(Integer remainingHours) {
        this.estimatedHoursNeeded = remainingHours;
    }

    public Integer getHoursLeft() {
        Calendar expectedTimeOfCompletion = Calendar.getInstance();
        expectedTimeOfCompletion.setTimeInMillis(startTime.getTime());
        expectedTimeOfCompletion.add(Calendar.HOUR_OF_DAY, estimatedHoursNeeded);

        Calendar currentDate = Calendar.getInstance();
        if(expectedTimeOfCompletion.before(currentDate)) {
            return 0;
        }
        else {
            long timeDifference = expectedTimeOfCompletion.getTimeInMillis() - currentDate.getTimeInMillis();
            Integer hoursBetween = (int) TimeUnit.MILLISECONDS.toHours(timeDifference);
            return hoursBetween;
        }
    }

    public void setHoursLeft(Integer count) {
        Calendar newExpectedTimeOfCompletion = Calendar.getInstance();
        newExpectedTimeOfCompletion.add(Calendar.HOUR_OF_DAY, count);
        long totalTimeNeeded = newExpectedTimeOfCompletion.getTimeInMillis() - startTime.getTime();
        Integer totalHoursNeeded = (int) TimeUnit.MILLISECONDS.toHours(totalTimeNeeded);
        setEstimatedHoursNeeded(totalHoursNeeded + 1);
    }

    public String getEstimatedTimeOfCompletion() {
        Calendar expectedTimeOfCompletion = Calendar.getInstance();
        expectedTimeOfCompletion.setTimeInMillis(startTime.getTime());
        expectedTimeOfCompletion.add(Calendar.HOUR_OF_DAY, estimatedHoursNeeded);
        return expectedTimeOfCompletion.getTime().toString();
    }

    public Integer getHoursSoFar() {
        Calendar expectedTimeOfCompletion = Calendar.getInstance();
        expectedTimeOfCompletion.setTimeInMillis(startTime.getTime());
        expectedTimeOfCompletion.add(Calendar.HOUR_OF_DAY, estimatedHoursNeeded);
        Date currentDate = new Date();
        if(expectedTimeOfCompletion.before(currentDate)) {
            return estimatedHoursNeeded;
        }
        else {
            long timeDifference = currentDate.getTime() - startTime.getTime();
            Integer hoursBetween = (int) TimeUnit.MILLISECONDS.toHours(timeDifference);
            return hoursBetween;
        }
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
        if (estimatedHoursNeeded != null ? !estimatedHoursNeeded.equals(task.estimatedHoursNeeded) : task.estimatedHoursNeeded != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (estimatedHoursNeeded != null ? estimatedHoursNeeded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskContent='" + taskContent + '\'' +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", estimatedHoursNeeded=" + estimatedHoursNeeded +
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
