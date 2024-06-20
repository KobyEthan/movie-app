package com.example.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
// -------- lombok annotations --------
// Takes care of getters, setters, and toString methods
@Data
// Makes a constructor with all the parameters
@AllArgsConstructor
// Makes a constructor wih no parameters
@NoArgsConstructor
// -------- lombok annotations --------
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    // This will cause the database to store only the ids of the review and the reviews will be in a separate collection
    // Called manual reference relationship
    @DocumentReference
    private List<Review> reviewIds;
}
