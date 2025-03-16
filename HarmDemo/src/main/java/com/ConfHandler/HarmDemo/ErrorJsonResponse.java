package com.ConfHandler.HarmDemo;

import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ErrorJsonResponse extends ResponseEntity<Map<String,Object>> {
    public ErrorJsonResponse(Object object, HttpStatusCode status) {
        super( Map.of("error",object), status);
    }


}
