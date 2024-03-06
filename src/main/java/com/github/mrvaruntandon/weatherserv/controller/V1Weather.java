package com.github.mrvaruntandon.weatherserv.controller;

import com.github.mrvaruntandon.weatherserv.models.WeatherResponse;

import com.github.mrvaruntandon.weatherserv.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.github.mrvaruntandon.weatherserv.constants.WeatherservConstants.*;

@RestController
@Slf4j
public class V1Weather {

    @Autowired
    WeatherService weatherService;

    /**
     * GET /v1/weather : Get weather information by postal code
     *
     * @param postalCode Postal code for the location (required)
     * @param countryCode Two-letter ISO country code (required)
     * @param transactionId Unique transaction ID for tracking purposes (optional)
     * @return Successful response (status code 200)
     *         or Bad request, missing or invalid parameters (status code 400)
     *         or Location not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = WEATHER_API_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<WeatherResponse> v1WeatherGet(
            @RequestParam(value = POSTAL_CODE, required = true) String postalCode,
            @RequestParam(value = COUNTRY_CODE, required = true) String countryCode,
            @RequestHeader(value = TRANSACTION_ID, required = false) String transactionId
    ) {
        return new ResponseEntity<>(weatherService.getWeather(postalCode, countryCode), HttpStatusCode.valueOf(200));
    }

}
