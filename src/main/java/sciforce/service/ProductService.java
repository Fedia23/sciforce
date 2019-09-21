package sciforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import sciforce.entity.Product;
import sciforce.repository.LocalJsonRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private LocalJsonRepository localJsonRepository;

    public List<Product> createProduct(Product localProduct) {
        List<Product> productList = localJsonRepository.loadFromJsonToList();
        productList.add(localProduct);

        return productList;
    }
}
