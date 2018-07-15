package grupa1.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @Column(name = "commentId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Basic
    @Column(name = "commentContent", nullable = false, length = 2100)
    private String commentContent;

    @Basic
    @Column(name = "timeMade", nullable = false)
    private Timestamp timeMade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskId", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Comment() {}
    public Comment(String commentContent, Timestamp timeMade) {
        this.commentContent = commentContent;
        this.timeMade = timeMade;
    }

    public Comment(String commentContent) {
        this(commentContent, new Timestamp(System.currentTimeMillis()));
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCommentId() {
        return commentId;
    }

    private void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }


    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }


    public Timestamp getTimeMade() {
        return timeMade;
    }

    public void setTimeMade(Timestamp timeMade) {
        this.timeMade = timeMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != null ? !commentId.equals(comment.commentId) : comment.commentId != null) return false;
        if (commentContent != null ? !commentContent.equals(comment.commentContent) : comment.commentContent != null)
            return false;
        if (timeMade != null ? !timeMade.equals(comment.timeMade) : comment.timeMade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (timeMade != null ? timeMade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", timeMade=" + timeMade +
                '}';
    }
}
