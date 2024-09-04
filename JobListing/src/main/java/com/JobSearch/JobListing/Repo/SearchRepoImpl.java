package com.JobSearch.JobListing.Repo;

import com.JobSearch.JobListing.Model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchRepoImpl implements SearchRepo {

    @Autowired
    private MongoClient client;

    @Override
    public List<Post> findByText(String text) {
        List<Post> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("database name");
        MongoCollection<Document> collection = database.getCollection("collection name");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("desc", "profile", "techs")))),
                new Document("$sort", new Document("exp", 1)),
                new Document("$limit", 5)
        ));

        for (Document doc : result) {
            Post post = new Post();
            post.setProfile(doc.getString("profile"));
            post.setDesc(doc.getString("desc"));
            post.setExp(doc.getInteger("exp"));
            post.setTechs(doc.getList("techs", String.class).toArray(new String[0]));
            posts.add(post);
        }

        return posts;
    }
}
