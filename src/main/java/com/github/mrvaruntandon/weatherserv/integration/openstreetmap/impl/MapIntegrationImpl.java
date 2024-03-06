package com.github.mrvaruntandon.weatherserv.integration.openstreetmap.impl;

import com.github.mrvaruntandon.weatherserv.integration.MapIntegration;
import com.github.mrvaruntandon.weatherserv.integration.openstreetmap.models.PostalCodeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.AbstractMap;
import java.util.Map;

@Slf4j
@Component
public class MapIntegrationImpl implements MapIntegration {
    @Override
    public Map.Entry<String, String> getLatitudeAndLongitude(String postalCode, String countryCode) {

        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://nominatim.openstreetmap.org/search?postalcode="+postalCode+"&country="+countryCode+"&format=json";
        try {
            ResponseEntity<PostalCodeInfo[]> responseEntity = restTemplate.getForEntity(url, PostalCodeInfo[].class);
            // Check for successful response
            if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
                for (PostalCodeInfo info : responseEntity.getBody()) {
                    log.info(info.toString());
                    return new AbstractMap.SimpleImmutableEntry<>(info.getLat(), info.getLon());
                }
            } else {
                log.error("Request failed with status code: {}", responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            log.error("Client error: {}", e.getStatusCode(), e);
        } catch (HttpServerErrorException e) {
            log.error("Server error: {}", e.getStatusCode(), e);
        } catch (Exception e) {
            log.error("An unexpected error occurred", e);
        }
        return null;
    }

}