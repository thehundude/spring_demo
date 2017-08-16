package group.helixlab.spring_demo.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Serializable> {

}
