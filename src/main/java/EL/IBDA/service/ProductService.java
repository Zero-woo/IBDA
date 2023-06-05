package EL.IBDA.service;

import EL.IBDA.domain.Member;
import EL.IBDA.domain.Product;
import EL.IBDA.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(String name) {
        Product product = findProductByName(name);
        productRepository.delete(product);
    }


    public Product findProductByName(String productName) {
        Optional<Product> findProduct = productRepository.findByName(productName);
        return findProduct.orElseThrow(() -> new IllegalStateException("없는 상품입니다."));
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }




}
