package com.gegesha.countrycodedemo.service;

import com.gegesha.countrycodedemo.model.dto.CountryDTO;
import com.gegesha.countrycodedemo.utils.Utils;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CountryService {

    public List<CountryDTO> countryList;

    public void initCountryList() {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        try {
            String[] data = Utils.CountryCodeData.split(",");
            for (String item : data
            ) {
                String[] splitItem = item.trim().split("\\|");
                if (splitItem.length == 2) {
                    countryDTOList.add(new CountryDTO(Utils.parseCountryCodeString(splitItem[1]), splitItem[0].trim()));
                }
            }
            countryList = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.countryList = countryDTOList;
    }

    public CountryDTO getCountyByPhoneCode(Integer code) {
        Optional<CountryDTO> dto = countryList.stream().filter(item -> item.getCode().equals(code)).findAny();
        return dto.orElse(null);
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }
}
