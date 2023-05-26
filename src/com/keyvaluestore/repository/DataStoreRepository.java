package com.keyvaluestore.repository;

import org.json.JSONObject;

public interface DataStoreRepository {
    public JSONObject addValue(String key, JSONObject value);
    public JSONObject getValue(String key);
    public JSONObject updateValue(String key, JSONObject value);
    public void deleteKey(String key);
}
