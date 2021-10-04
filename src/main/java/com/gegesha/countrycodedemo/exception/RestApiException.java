package com.gegesha.countrycodedemo.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestApiException extends Exception {
    public String key;

}
