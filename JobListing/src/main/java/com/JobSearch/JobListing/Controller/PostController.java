package com.JobSearch.JobListing.Controller;

import com.JobSearch.JobListing.Model.Post;
import com.JobSearch.JobListing.Repo.PostRepo;
import com.JobSearch.JobListing.Repo.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController
{

    @Autowired
    PostRepo repo;
    @Autowired
    SearchRepo srepo;

    @GetMapping("/posts")
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}