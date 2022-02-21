package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReviewService {

    private static Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public ReviewDTO findById(Long id) {
        Optional<Review> obj = reviewRepository.findById(id);
        Review entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new ReviewDTO(entity);
    }

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        User user = authService.authenticated();
        authService.validateSelfOrAdmin(user.getId());

        Review entity = new Review();
        Movie movie = movieRepository.getOne(dto.getMovieId());
        entity.setMovie(movie);
        entity.setText(dto.getText());
        entity.setUser(user);
        entity = reviewRepository.save(entity);
        return new ReviewDTO(entity);
    }
}
