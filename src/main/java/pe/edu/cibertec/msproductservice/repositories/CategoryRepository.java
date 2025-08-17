package pe.edu.cibertec.msproductservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.msproductservice.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
