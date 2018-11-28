package api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String genre;

    public Long getId() {
	    return id;
    }

    public void setId(Long id) {
	    this.id = id;
     }

    public String getName() {
	    return name;
    }

    public void setName(String name) {
	    this.name = name;
    }

    public String getGenre() {
	    return genre;
    }

    public void setGenre(String genre) {
	    this.genre = genre;
    }
}
