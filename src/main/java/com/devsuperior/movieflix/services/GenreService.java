package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private static Logger logger = LoggerFactory.getLogger(GenreService.class);

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> list = genreRepository.findAll();
        return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
    }
}
