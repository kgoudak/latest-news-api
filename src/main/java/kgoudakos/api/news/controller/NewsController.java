package kgoudakos.api.news.controller;

import kgoudakos.api.news.model.News;
import kgoudakos.api.news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class NewsController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public News getNews(HttpServletRequest request) {
        return newsService.getNews(request);
    }
}
