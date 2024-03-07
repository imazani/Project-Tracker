package com.imazani.ProjectTracker.model;

import org.springframework.data.annotation.Transient;
import java.time.LocalDateTime;
import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;

public class Note {
    private String userName;
    private String content;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;
    @Transient
    Project project;

    public Note(String userName, String content) {
        this.userName = userName;
        this.content = content;
        this.publishedOn = LocalDateTime.now();
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDateTime publishedOn) {
        this.publishedOn = publishedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Note{" +
                "userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                ", publishedOn=" + publishedOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
