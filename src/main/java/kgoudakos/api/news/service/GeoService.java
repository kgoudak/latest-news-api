package kgoudakos.api.news.service;

import kgoudakos.api.news.model.GeoIP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

@Service
public class GeoService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GeoService.class);

    @Value("${geoIpBaseUrl}")
    private String baseUrl;

    private String getIP() {
        LOGGER.info("Try to determine IP");
        try {
            URL checkIpService = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(checkIpService.openStream()));
            String ipAddress = in.readLine();
            LOGGER.info("IP Address: " + ipAddress);
            return ipAddress;
        } catch (IOException e) {
            LOGGER.warn("There was an error while obtaining IP info");
            return "8.8.8.8";    // return a default value
        }
    }

    public String getCountryCode() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(baseUrl, getIP());
        GeoIP geoIP = restTemplate.getForObject(url, GeoIP.class);
        return Objects.requireNonNull(geoIP).getCountryCode();
    }

}
