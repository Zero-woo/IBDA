package EL.IBDA.controller;


import EL.IBDA.domain.Product;
import EL.IBDA.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "제품 API")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "제품 생성",description = "제품 생성하기")
    @PostMapping("/product/new")
    public void create(@RequestBody @Valid Product product) {
        productService.saveProduct(product);
    }
    @Operation(summary = "모든 제품 조회",description = "모든 제품 조회하기")
    @GetMapping("/products")
    public List<Product> list() {
        List<Product> products = productService.findProducts();
        return products;
    }
    
    @Operation(summary = "제품 삭제",description = "제품명으로 제품 삭제하기")
    @DeleteMapping("/product/{productName}")
    public void deleteProduct(@PathVariable("productName")String productName){
        productService.deleteProduct(productName);
    }

    @Operation(summary = "제품 검색",description = "제품명으로 제품 검색하기") 
    @GetMapping("/product/{productName}")
    public Product findProduct(@PathVariable("productName") String productName) {

        Product product = productService.findProductByName(productName);
        return product;
    }
}
