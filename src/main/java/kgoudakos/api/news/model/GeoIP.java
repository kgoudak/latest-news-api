package kgoudakos.api.news.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoIP {

    @JsonProperty("country_code")
    private String countryCode;
    private String city;
}
