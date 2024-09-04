package com.JobSearch.JobListing.Repo;

import com.JobSearch.JobListing.Model.Post;

import java.util.List;

public interface SearchRepo
{
    List<Post> findByText(String text);
}
