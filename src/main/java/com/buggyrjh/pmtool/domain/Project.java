package com.buggyrjh.pmtool.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date startDate;
    private Date end_date;
    private Date createdAt;
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
    public Date getEnd_date() { return end_date; }
    public Long getId() { return id; }

                // ##### Setters ##### //
    public void setProjectIdentifier(String projectIdentifier) { this.projectIdentifier = projectIdentifier; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    public void setEnd_date(Date end_date) { this.end_date = end_date; }
    public void setId(Long id) { this.id = id; }

    @PrePersist
    protected void onCreate() { this.createdAt = new Date(); } // Every time we make a new data entry set a new date
    @PreUpdate
    protected void onUpdate() { this.updatedAt = new Date();} // Every time we update a data entry set a new date
}
