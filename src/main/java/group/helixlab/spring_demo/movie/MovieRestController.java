package group.helixlab.spring_demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Movie> getAllMovies() {
        return movieService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Movie getMovieById (@PathVariable("id") int id) {
        return movieService.findMovieById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    Movie createMovie (@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    Movie updateMovieById (@PathVariable("id") int id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void deleteMovieById (@PathVariable("id") int id) {
        movieService.deleteMovieById(id);
    }
}
