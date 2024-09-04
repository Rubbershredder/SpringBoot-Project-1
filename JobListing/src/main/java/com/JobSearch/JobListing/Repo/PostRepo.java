package com.JobSearch.JobListing.Repo;

import com.JobSearch.JobListing.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String> {

}
