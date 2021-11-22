package com.tiendis.tiendis.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String mensaje, HttpStatus status, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mensaje", mensaje);
        map.put("status", status);
        map.put("data", responseObj);
        return new ResponseEntity<Object>(map, status);
    }
}
