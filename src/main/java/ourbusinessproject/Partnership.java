package ourbusinessproject;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Partnership {

    @NotNull
    Date creationDate;

    @NotNull
    Enterprise enterprise;

    @NotNull
    Project project;

    public Project getProject() {
        return project;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
