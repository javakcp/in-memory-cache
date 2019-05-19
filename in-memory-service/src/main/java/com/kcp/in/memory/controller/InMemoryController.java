package com.kcp.in.memory.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author kapanda
 *
 */
@RestController
public class InMemoryController {
    Map<String, String> map = new ConcurrentHashMap<>();

    public InMemoryController() {
        logger.info("Bean Created");
    }

    private static final Logger logger = LoggerFactory.getLogger(InMemoryController.class);

    @ApiOperation(value = "Set key and value", notes = "set in map")
    @RequestMapping(value = "/SET/{key}/{value}", produces = {
            MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<String> setKeyValue(@PathVariable("key") String key, @PathVariable("value") String value) {
        map.put(key, value);
        logger.info("Kailash {}", map);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/GET/{key}", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    @ApiOperation(value = "Get value of Key", notes = "Returns the value of key")
    public ResponseEntity<String> getValueOfKey(@PathVariable("key") String key) {
        logger.info("Get all inventory");
        String value = map.get(key);
        if (StringUtils.isNotEmpty(value)) {
            return new ResponseEntity<>(value, HttpStatus.OK);
        }
        return new ResponseEntity<>("key does not exist", HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Find size of the map", notes = "Returns the map size")
    @RequestMapping(value = "/SIZE}", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity<Integer> getSize() {
        int size = map.size();
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @ApiOperation(value = "get INCR", notes = "increament the value")
    @RequestMapping(value = "/INCR/{key}", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<String> getINCRValue(@PathVariable("key") String key) {
        logger.info("Kailash {}", map);
        String value = map.get(key);
        if (StringUtils.isNotEmpty(value)) {
            return new ResponseEntity<>(value, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Success", HttpStatus.BAD_REQUEST);
    }

}
