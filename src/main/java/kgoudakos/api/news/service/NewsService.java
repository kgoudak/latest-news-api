package kgoudakos.api.news.service;

import kgoudakos.api.news.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(NewsService.class);

    @Value("${newsBaseUrl}")
    private String baseUrl;

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private GeoService geoService;

    public News getNews() {
        RestTemplate restTemplate = new RestTemplate();
        String countryCode = geoService.getCountryCode();
        LOGGER.info("Country code: " + countryCode);

        String url = String.format(baseUrl, countryCode, apiKey);
        return restTemplate.getForObject(url, News.class);
    }
}
