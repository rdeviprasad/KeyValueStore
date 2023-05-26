package com.keyvaluestore.model;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private Map<String, JSONObject> dataStore;

    public DataStore() {
        dataStore = new HashMap<>();
    }

    public JSONObject getValue(String key) {
        return dataStore.get(key);
    }

    public void putValue(String key, JSONObject value) {
        dataStore.put(key, value);
    }

    public void removeKey(String key) {
        dataStore.remove(key);
    }
}
