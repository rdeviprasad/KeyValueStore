package com.keyvaluestore.controller;

import com.keyvaluestore.service.DataStoreService;
import org.json.JSONObject;

public class DataStoreController {

    private final DataStoreService dataStoreService;

    public DataStoreController(DataStoreService service) {
        this.dataStoreService = service;
    }

    public JSONObject getValue(String key) {
        return dataStoreService.getValueForKey(key);
    }

    public JSONObject addValue(String key, JSONObject value) {
        return dataStoreService.addValueForKey(key, value);
    }

    public JSONObject updateValue(String key, JSONObject value) {
        return dataStoreService.updateValueForKey(key, value);
    }
}
