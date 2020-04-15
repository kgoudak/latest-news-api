package kgoudakos.api.news.model;

import lombok.Data;

@Data
public class Article {

    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
