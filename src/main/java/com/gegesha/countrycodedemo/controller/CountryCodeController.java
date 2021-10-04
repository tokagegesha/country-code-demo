package com.gegesha.countrycodedemo.controller;

import com.gegesha.countrycodedemo.exception.RestApiException;
import com.gegesha.countrycodedemo.model.dto.CountryDTO;
import com.gegesha.countrycodedemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countyCode")
public class CountryCodeController {

    final CountryService countryService;

    @Autowired
    public CountryCodeController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/byPhoneCode")
    public ResponseEntity<String> getCountryByPhoneCode(@RequestParam("phoneCode") String phoneCode) throws RestApiException {
        try {
            Integer code = Integer.parseInt(phoneCode);
            CountryDTO countyByPhoneCode = countryService.getCountyByPhoneCode(code);
            if (countyByPhoneCode == null) {
                throw new RestApiException("county_not_found");
            }
            return ResponseEntity.ok(countyByPhoneCode.getName());

        } catch (RestApiException ex) {
            throw new RestApiException(ex.getKey());
        } catch (Exception ex) {
            throw new RestApiException("invalid_input");
        }
    }

}
