package com.forum.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_topic")
public class Topic {
    public static final int DIGEST_TOPIC = 1;
    public static final int NOT_DIGEST_TOPIC = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topic_id")
    private int topicId;

    @Column(name="topic_title")
    private String topicTitle;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="board_id")
    private int boardId;

    @Column(name="last_post")
    private Date lastPost = new Date();

    @Column(name="create_time")
    private Date createTime = new Date();

    @Column(name="topic_views")
    private int topicViews=0;

    @Column(name="topic_replies")
    private int replies=0;
    @Column(name="digest")
    private int digest = NOT_DIGEST_TOPIC;

    public static int getDigestTopic() {
        return DIGEST_TOPIC;
    }

    public static int getNotDigestTopic() {
        return NOT_DIGEST_TOPIC;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicTitle='" + topicTitle + '\'' +
                ", user=" + user +
                ", boardId=" + boardId +
                ", lastPost=" + lastPost +
                ", createTime=" + createTime +
                ", topicViews=" + topicViews +
                ", replies=" + replies +
                ", digest=" + digest +
                '}';
    }
}
