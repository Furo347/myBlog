package org.ynovschool.myBlog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AuthorContributionDTO {

    @NotNull(message = "L'id de l'auteur ne peut pas être nul")
    @Positive(message = "L'id de l'auteur doit être positif")
    private Long authorId;

    @NotBlank(message = "Le rôle de l'auteur ne peut pas être vide")
    private String contribution;

    //getters and setters
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }
}
