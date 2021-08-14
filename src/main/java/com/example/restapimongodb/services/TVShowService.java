package com.example.restapimongodb.services;

import com.example.restapimongodb.models.MarvelMovie;
import com.example.restapimongodb.models.TVShow;
import com.example.restapimongodb.models.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVShowService
{
    @Autowired
    private TVShowRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TVShow> getTVShows()
    {
        return repository.findAll();
    }
    public  void insertIntoTVShows(TVShow tvshow)
    {
        repository.insert(tvshow);
    }
    public Optional<TVShow> getATVShow(String id)
    {
        return repository.findById(id);
    }

    public void deleteATVShow(String id)
    {
        repository.deleteById(id);
    }
    public List<TVShow> getTVFeatured(String mfeatured)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("tvshows_featured").is(mfeatured)); //we can put multiple type of queries
        List<TVShow> tvshow= mongoTemplate.find(query, TVShow.class);
        return tvshow;
    }
    public List<TVShow> getTVTitle(String title)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("tvshows_title").is(title)); //we can put multiple type of queries
        List<TVShow> tvshow= mongoTemplate.find(query, TVShow.class);
        return tvshow;
    }
    public  TVShow editTVShow(String id,TVShow newTVShowData)
    {
        //get the resource with the new data
        Optional<TVShow> tvShow= repository.findById(id);

        //validation if the id is correct or not

        tvShow.get().setTvshows_title(newTVShowData.getTvshows_title());
        tvShow.get().setTvshows_featured(newTVShowData.getTvshows_featured());
        tvShow.get().setTvshows_price(newTVShowData.getTvshows_price());
        tvShow.get().setTvshows_rent(newTVShowData.getTvshows_rent());
        tvShow.get().setTvshows_large_poster(newTVShowData.getTvshows_large_poster());
        tvShow.get().setTvshows_tag(newTVShowData.getTvshows_tag());
        tvShow.get().setTvshows_purchase_outright(newTVShowData.getTvshows_purchase_outright());
        tvShow.get().setTvshows_synopsis(newTVShowData.getTvshows_synopsis());
        tvShow.get().setTvshows_description(newTVShowData.getTvshows_description());

        //update the found resource with new data
        TVShow updateTVShow = repository.save(tvShow.get());
        return updateTVShow;


        //commit the update by saving it
    }
}
