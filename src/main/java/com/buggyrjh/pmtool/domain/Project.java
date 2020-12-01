package com.buggyrjh.pmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Project must have a name.")
    private String projectName;
    @NotBlank(message="Project Identifier is required.")
    @Size(min=4, max=10, message="Must be at least 4 and no more than 10 characters long.")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message="Description is required.")
    private String description;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date startDate;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date endDate;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date createdAt;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date updatedAt;

    public Project() {
    }

                // ##### Getters ##### //
    public String getProjectIdentifier() { return projectIdentifier; }
    public String getProjectName() { return projectName; }
    public String getDescription() { return description; }
    public Date getStartDate() { return startDate; }
    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    public Date getEndDate() { return endDate; }
    public Long getId() { return id; }

                // ##### Setters ##### //
    public void setProjectIdentifier(String projectIdentifier) { this.projectIdentifier = projectIdentifier; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setId(Long id) { this.id = id; }

    @PrePersist
    protected void onCreate() {
        this.createdAt = this.updatedAt = new Date(); } // Every time we make a new data entry set a new date
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date();} // Every time we update a data entry set a new date
}
