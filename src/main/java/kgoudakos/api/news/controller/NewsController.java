package kgoudakos.api.news.controller;

import kgoudakos.api.news.model.News;
import kgoudakos.api.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/")
    public News getNews() {
        return newsService.getNews();
    }
}
