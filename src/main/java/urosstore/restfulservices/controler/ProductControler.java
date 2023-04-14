package urosstore.restfulservices.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urosstore.restfulservices.controler.model.ProductID;
import urosstore.restfulservices.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductControler {

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result= new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product(
                "1",
                "Prvi proizvod",
                 new BigDecimal("1239012.21312")));
        result.add(new Product(
                "2",
                "Drugi proizvod",
                new BigDecimal("1239012.21312")));
        result.add(new Product(
                "3",
                "Treci proizvod",
                new BigDecimal("1239012.21312")));

        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable final  String id){
        System.out.println(id);
        return new Product("888",
                "Return single product",
                new BigDecimal(21312.12312));
    }

}
