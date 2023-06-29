package com.cydeo.client;

import com.cydeo.dto.WeatherDTO;
import com.cydeo.dto.country.CountryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://restcountries.com/v3.1", name = "COUNTRY-CLIENT")
public interface CountryApiClient {

    @GetMapping("/name/{name}")
    List<CountryDTO> getCountryInfo(@PathVariable ("name") String name); //we don't need access key because there is no restriction on this website)



}
