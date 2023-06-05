package EL.IBDA.repository;

import EL.IBDA.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    <S extends Product>S save(S entity);

    void delete(Product product);

    Optional<Product> findByName(String name);

    List<Product> findAll();

}

