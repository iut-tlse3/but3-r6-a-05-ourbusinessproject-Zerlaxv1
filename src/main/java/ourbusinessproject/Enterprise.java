package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Size(min = 10)
    private String description;

    @NotBlank
    private String contactName;

    @NotBlank
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String mail) {
        this.contactEmail = mail;
    }

    public Long getId() {
        return id;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if (this.projects == null) this.projects = new HashSet<Project>();
        this.projects.add(project);
    }

    public String getName() {
        return this.name;
    }
}
