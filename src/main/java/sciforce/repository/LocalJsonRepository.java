package sciforce.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Repository;
import sciforce.entity.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocalJsonRepository {

    private Gson gson;
    private Product product;
    private List<Product> products;

    public LocalJsonRepository() {
        this.product = new Product();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.products = loadFromJsonToList();
    }

    public List<Product> loadFromJsonToList() {
        String p = "C:/scif/mm.json";
        JsonReader jsonReader = null;
        Type listType = new TypeToken<List<Product>>() {
        }.getType();
        try {
            jsonReader = new JsonReader(new FileReader(p));
            products = gson.fromJson(jsonReader, listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return products != null ? products : new ArrayList<>();
    }
}
