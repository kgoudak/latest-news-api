package kgoudakos.api.news.service;

import kgoudakos.api.news.model.GeoIP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.StringTokenizer;

@Service
public class GeoService {

    @Value("${geoIpBaseUrl}")
    private String baseUrl;

    public String getCountryCode(HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(baseUrl, getIP(request));
        GeoIP geoIP = restTemplate.getForObject(url, GeoIP.class);
        return Objects.requireNonNull(geoIP).getCountryCode();
    }

    private String getIP(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
        }
    }

}
