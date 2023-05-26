package com.keyvaluestore.service;

import com.keyvaluestore.model.DataStore;
import com.keyvaluestore.repository.DataStoreRepository;
import org.json.JSONObject;

public class DataStoreService {
    private final DataStoreRepository repository;

    private final DataStore inMemoryStore;

    public DataStoreService(DataStoreRepository repository, DataStore inMemoryStore) {
        this.repository = repository;
        this.inMemoryStore = inMemoryStore;
    }

    public JSONObject getValueForKey(String key) {
        return inMemoryStore.getValue(key);
    }

    public JSONObject addValueForKey(String key, JSONObject value) {
        repository.addValue(key, value);
        inMemoryStore.putValue(key, value);
        return value;
    }

    public JSONObject updateValueForKey(String key, JSONObject value) {
        repository.updateValue(key, value);
        inMemoryStore.putValue(key, value);
        return value;
    }

    public void deleteKey(String key) {
        repository.deleteKey(key);
        inMemoryStore.removeKey(key);
    }

}
