package com.keyvaluestore.repository;

import org.json.JSONObject;

import java.io.*;

public class FileBasedDataStore implements DataStoreRepository {

    private final File persistenceStorage;
    public final String SENTINAL = "{\"name\": \"SENTINAL\"}";

    public FileBasedDataStore(String filename) {
        persistenceStorage = new File(filename);

//        try(FileReader fileReader = new FileReader(filename);
//                BufferedReader reader = new BufferedReader(fileReader);) {
//            String line = null;
//            while((line = reader.readLine()) != null) {
//                String[] keyAndValue = line.split(",");
//                String key = keyAndValue[0];
//                JSONObject value = new JSONObject(keyAndValue[1]);
//
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    // TODO: create file object, write to file on each create, update, delete
    @Override
    public JSONObject addValue(String key, JSONObject value) {
        writeToFile(key + "," + value.toString());
        return value;
    }

    @Override
    public JSONObject getValue(String key) {
        return null;
    }

    @Override
    public JSONObject updateValue(String key, JSONObject value) {
        writeToFile(key + "," + value.toString());
        return value;
    }

    @Override
    public void deleteKey(String key) {
        writeToFile(key + "," + SENTINAL);
    }

    private void writeToFile(String line) {
        try (
                FileWriter fileWriter = new FileWriter(persistenceStorage);
                BufferedWriter writer = new BufferedWriter(fileWriter);) {
             writer.write(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject readFromFile(String key) {
        try(FileReader fileReader = new FileReader(persistenceStorage);
        BufferedReader reader = new BufferedReader(fileReader);) {
            String line = null;
            JSONObject currentValue = new JSONObject();
            while((line = reader.readLine()) != null) {
                String[] keyAndValue = line.split(",");
                if(key.equals(keyAndValue[0])) {
                    currentValue = new JSONObject(keyAndValue[1]);
                }
            }
            return currentValue;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}
