package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewDTO implements Serializable {
    private static final long serialVerisonUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String text;
    private Long movieId;
    private UserDTO userDto;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, Long movieId, UserDTO userDto) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.userDto = userDto;
    }

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        movieId = entity.getMovie().getId();
        userDto = new UserDTO(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDTO getUser() {
        return userDto;
    }

    public void setUser(UserDTO userDto) {
        this.userDto = userDto;
    }
}
