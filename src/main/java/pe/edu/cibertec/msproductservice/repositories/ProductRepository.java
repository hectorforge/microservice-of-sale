package pe.edu.cibertec.msproductservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.msproductservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByCategory_NameIgnoreCase(String name, Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE LOWER(p.category.name) = LOWER(:categoryName) " +
            "AND LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%'))")
    Page<Product> findByCategoryAndProductName(
            @Param("categoryName") String categoryName,
            @Param("productName") String productName,
            Pageable pageable
    );
}