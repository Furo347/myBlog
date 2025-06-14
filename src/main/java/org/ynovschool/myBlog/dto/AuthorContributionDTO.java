package org.ynovschool.myBlog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AuthorContributionDTO {
    @NotNull(message = "L'ID de l'auteur ne doit pas être nul")
    @Positive(message = "L'ID de l'auteur doit être un nombre positif")
    private Long authorId;

    @NotBlank(message = "La contribution de l'auteur ne doit pas être vide")
    private String contribution;

    public @NotNull(message = "L'ID de l'auteur ne doit pas être nul") @Positive(message = "L'ID de l'auteur doit être un nombre positif") Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(@NotNull(message = "L'ID de l'auteur ne doit pas être nul") @Positive(message = "L'ID de l'auteur doit être un nombre positif") Long authorId) {
        this.authorId = authorId;
    }

    public @NotBlank(message = "La contribution de l'auteur ne doit pas être vide") String getContribution() {
        return contribution;
    }

    public void setContribution(@NotBlank(message = "La contribution de l'auteur ne doit pas être vide") String contribution) {
        this.contribution = contribution;
    }
}