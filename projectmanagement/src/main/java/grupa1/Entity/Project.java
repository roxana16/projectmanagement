package grupa1.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @Column(name = "projectId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Basic
    @Column(name = "projectContent", nullable = true, length = 2100)
    private String projectContent;

    @Basic
    @Column(name = "projectTitle", nullable = false, length = 100)
    private String projectTitle;

    @Basic
    @Column(name = "releaseDate", nullable = true)
    private Timestamp releaseDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "projectId")
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String projectTitle, String projectDescription, Date releaseDate) {
        this.projectContent = projectDescription;
        this.projectTitle = projectTitle;
        this.releaseDate = new Timestamp(releaseDate.getTime());
    }

    public Project(String projectTitle, String projectDescription) {
        this.projectTitle = projectTitle;
        this.projectContent = projectDescription;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.DATE, 365);
        this.releaseDate = new Timestamp(calendar.getTimeInMillis());
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setProject(this);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectId != null ? !projectId.equals(project.projectId) : project.projectId != null) return false;
        if (projectContent != null ? !projectContent.equals(project.projectContent) : project.projectContent != null)
            return false;
        if (projectTitle != null ? !projectTitle.equals(project.projectTitle) : project.projectTitle != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(project.releaseDate) : project.releaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (projectContent != null ? projectContent.hashCode() : 0);
        result = 31 * result + (projectTitle != null ? projectTitle.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectContent='" + projectContent + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", tasks=" + tasks +
                '}';
    }
}
