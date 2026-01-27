package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;

public class Project {

    @NotBlank
    private String title;

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
