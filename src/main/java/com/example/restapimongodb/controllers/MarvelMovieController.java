package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.MarvelMovie;
import com.example.restapimongodb.services.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MarvelMovieController
{
    @Autowired
    private MarvelService service;
    @GetMapping("/marvelmovies")
    public ResponseEntity getMarvelMovies()
    {
        var customizedResponse = new CustomizedResponse("A list of all Marvel Movies", service.getMarvelMovies());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    //  /marvelmovies/featured/marvel_featured=yes
    @GetMapping("/marvelmovies/featured")
    public ResponseEntity getMarvelMoviesByFeature(@RequestParam(value = "marvel_featured") String mfeatured)
    {
        var customizedResponse = new CustomizedResponse("A list of all featured Marvel Movies", service.getMarvelMoviesFeatured(mfeatured));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    //  /marvelmovies/featured/title=Captain America && limit=15
    @GetMapping("/marvelmovies/title")
    public ResponseEntity getMarvelMoviesByTitle(@RequestParam(value = "marvel_title") String title)
    {
        var customizedResponse = new CustomizedResponse("A list of all Marvel Movies with title", service.getMarvelMoviesTitle(title));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    @GetMapping("/marvelmovies/{id}")
    public ResponseEntity getAMarvelMovie(@PathVariable("id") String id)
    {
        var customizedResponse = new CustomizedResponse("Marvel Movie with id:" +id, Collections.singletonList(service.getAMarvelMovie(id)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @PostMapping(value = "/marvelmovies",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public  ResponseEntity addMarvelMovie(@RequestBody MarvelMovie marvelmovie)
    {
        service.insertIntoMarvelMovies(marvelmovie);
        var customizedResponse = new CustomizedResponse("Marvel Movie has been added successfully:", Collections.singletonList(marvelmovie));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @DeleteMapping("/marvelmovies/{id}")
    public ResponseEntity deleteAMarvelMovie(@PathVariable("id") String id)
    {
        service.deleteAMarvelMovie(id);
        return new ResponseEntity("Deleted Movie with id: "+id,HttpStatus.OK);
    }
    @PutMapping(value="marvelmovies/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMarvelMovie(@PathVariable("id") String id, @RequestBody MarvelMovie newmarvelMovie)
    {
        //validation code

        var customizedResponse = new CustomizedResponse("Marvel Movie with id: "+id+ " was updated successfully", Collections.singletonList(service.editMarvelMovie(id, newmarvelMovie)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

}
