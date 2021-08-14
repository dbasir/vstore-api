package com.example.restapimongodb.services;

import com.example.restapimongodb.models.MarvelMovie;
import com.example.restapimongodb.models.MarvelMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

//import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class MarvelService
{
    @Autowired
    private MarvelMovieRepository repository;
    //Repo obj is required for basic querying - get, put, post, del
    @Autowired
    private MongoTemplate mongoTemplate;
    //MongoTemp object is required for advance querying -filter
    public List<MarvelMovie> getMarvelMovies()
    {
        return repository.findAll();
    }
    public  void insertIntoMarvelMovies(MarvelMovie marvelmovie)
    {
        repository.insert(marvelmovie);
    }
    public Optional<MarvelMovie> getAMarvelMovie(String id)
    {
        return repository.findById(id);
    }

    public void deleteAMarvelMovie(String id)
    {
        repository.deleteById(id);
    }

    public List<MarvelMovie> getMarvelMoviesFeatured(String mfeatured)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("marvel_featured").is(mfeatured)); //we can put multiple type of queries
        System.out.println("query - " + query.toString());
        List<MarvelMovie> marvelMovies= mongoTemplate.find(query, MarvelMovie.class);
        return marvelMovies;
    }

    public List<MarvelMovie> getMarvelMoviesTitle(String title)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("marvel_title").is(title)); //we can put multiple type of queries
        List<MarvelMovie> marvelMovies= mongoTemplate.find(query, MarvelMovie.class);
        return marvelMovies;
    }
    public  MarvelMovie editMarvelMovie(String id,MarvelMovie newMarvelmovieData)
    {
        //get the resource with the new data
        Optional<MarvelMovie> marvelMovie= repository.findById(id);

        //validation if the id is correct or not

        marvelMovie.get().setMarvel_title(newMarvelmovieData.getMarvel_title());
        marvelMovie.get().setMarvel_featured(newMarvelmovieData.getMarvel_featured());
        marvelMovie.get().setMarvel_rent(newMarvelmovieData.getMarvel_rent());
        marvelMovie.get().setMarvel_price(newMarvelmovieData.getMarvel_price());
        marvelMovie.get().setMarvel_tag(newMarvelmovieData.getMarvel_tag());
        marvelMovie.get().setMarvel_large_poster(newMarvelmovieData.getMarvel_large_poster());
        marvelMovie.get().setMarvel_purchase_outright(newMarvelmovieData.getMarvel_purchase_outright());
        marvelMovie.get().setMarvel_synopsis(newMarvelmovieData.getMarvel_synopsis());
        marvelMovie.get().setMarvel_description(newMarvelmovieData.getMarvel_description());

        //update the found resource with new data
        MarvelMovie updateMarvelMovie = repository.save(marvelMovie.get());
        return updateMarvelMovie;


        //commit the update by saving it
    }
}
