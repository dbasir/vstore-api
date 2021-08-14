package com.example.restapimongodb.controllers;

import com.example.restapimongodb.CustomizedResponse;
import com.example.restapimongodb.models.MarvelMovie;
import com.example.restapimongodb.models.TVShow;
import com.example.restapimongodb.services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TVShowController
{
    @Autowired
    private TVShowService service;
    @GetMapping("/tvshows")
    public ResponseEntity getTVShows()
    {
        var customizedResponse = new CustomizedResponse("A list of all TV Shows", service.getTVShows());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    //localhost:5000/tvshows/featured?tvshows_featured=No
    @GetMapping("/tvshows/featured")
    public ResponseEntity getTVShowsByFeature(@RequestParam(value = "tvshows_featured") String mfeatured)
    {
        var customizedResponse = new CustomizedResponse("A list of all featured TV Shows", service.getTVFeatured(mfeatured));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    //localhost:5000/tvshows/title?tvshows_title=The+Office
    @GetMapping("/tvshows/title")
    public ResponseEntity getTVShowsByTitle(@RequestParam(value = "tvshows_title") String title)
    {
        var customizedResponse = new CustomizedResponse("A list of all TV Shows with title", service.getTVTitle(title));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/tvshows/{id}")
    public ResponseEntity getATVShow(@PathVariable("id") String id)
    {
        var customizedResponse = new CustomizedResponse("TV Show with id:" +id, Collections.singletonList(service.getATVShow(id)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @PostMapping(value = "/tvshows",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public  ResponseEntity addATVShow(@RequestBody TVShow tvshow)
    {
        service.insertIntoTVShows(tvshow);
        var customizedResponse = new CustomizedResponse("TV Show has been added successfully:", Collections.singletonList(tvshow));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @DeleteMapping("/tvshows/{id}")
    public ResponseEntity deleteATVShow(@PathVariable("id") String id)
    {
        service.deleteATVShow(id);
        return new ResponseEntity("Deleted TV Show with id: "+id,HttpStatus.OK);
    }

    @PutMapping(value="tvshows/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editTVShow(@PathVariable("id") String id, @RequestBody TVShow newtvshow)
    {
        //validation code

        var customizedResponse = new CustomizedResponse("TV Show with id: "+id+ " was updated successfully", Collections.singletonList(service.editTVShow(id, newtvshow)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
}
