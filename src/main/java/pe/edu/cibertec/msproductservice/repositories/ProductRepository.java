package pe.edu.cibertec.msproductservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.msproductservice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}