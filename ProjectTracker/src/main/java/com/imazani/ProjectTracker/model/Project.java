package com.imazani.ProjectTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project {

    @Id@JsonIgnore
    private Integer id;
    //private String assignedTo;
    private String status;
    private String stage;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private AggregateReference<Profile, Integer> assignedTo;
    private final Set<Note> notes = new HashSet<>();

    public Project(String status, String stage, AggregateReference<Profile, Integer> assignedTo) {
        this.status = status;
        this.stage = stage;
        this.assignedTo = assignedTo;
        this.createdOn = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public AggregateReference<Profile, Integer> getUser() {
        return assignedTo;
    }

    public void setUser(AggregateReference<Profile, Integer> user) {
        this.assignedTo = assignedTo;
    }

    public void setNotes(Set<Note> notes){
        notes.forEach(this::addNote);
    }

    public Set<Note> getNotes(){
        return notes;
    }

    public void addNotes(List<Note> notes) {
        notes.forEach(this::addNote);
    }

    public void addNote(Note note) {
        notes.add(note);
        note.project = this;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", stage='" + stage + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
