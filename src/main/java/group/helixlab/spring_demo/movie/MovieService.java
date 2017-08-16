package group.helixlab.spring_demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    Movie findMovieById(int id) {
        return movieRepository.findOne(id);
    }

    Movie createMovie(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    void deleteMovieById(int id) {
        Movie movie = movieRepository.findOne(id);
        movieRepository.delete(movie);
    }

    Movie update(int id, Movie movie) {
        if(movieRepository.findOne(id).getId() == id)
            return movieRepository.saveAndFlush(movie);
        throw new NullPointerException();
    }
}
