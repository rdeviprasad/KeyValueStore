import com.keyvaluestore.controller.DataStoreController;
import com.keyvaluestore.model.DataStore;
import com.keyvaluestore.repository.DataStoreRepository;
import com.keyvaluestore.repository.FileBasedDataStore;
import com.keyvaluestore.service.DataStoreService;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    private static final String FILE_NAME = "store.csv";

    private static final File file = new File(FILE_NAME);

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        DataStoreRepository repository = new FileBasedDataStore(FILE_NAME);
        DataStoreService service = new DataStoreService(repository, dataStore);
        DataStoreController controller = new DataStoreController(service);
        try(
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);) {
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] keyAndValue = line.split(",");
                String key = keyAndValue[0];
                String strvalue = keyAndValue[1].trim();
                System.out.println("next value: " + strvalue);
                JSONObject value = new JSONObject(strvalue);
                dataStore.putValue(key, value);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(controller.getValue("a"));
    }
}