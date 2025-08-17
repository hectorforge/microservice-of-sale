package pe.edu.cibertec.msproductservice.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.msproductservice.models.Product;

public interface IProductService {
    Page<Product> findAll(int page, int size, String sortBy, String sortDir);
}
