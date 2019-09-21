package sciforce.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sciforce.entity.Product;
import sciforce.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/interactive")
public class ProductRestController {

    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> calculateProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
