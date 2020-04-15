package kgoudakos.api.news.model;

import lombok.Data;

import java.util.List;

@Data
public class News {

    private int totalResults;
    private List<Article> articles;

}
