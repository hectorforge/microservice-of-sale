package pe.edu.cibertec.msproductservice.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.msproductservice.dtos.PageResponseDTO;
import pe.edu.cibertec.msproductservice.dtos.response.ResponseDTO;
import pe.edu.cibertec.msproductservice.models.Product;

public interface IProductService {
    Page<Product> findAll(int page, int size, String sortBy, String sortDir);
    PageResponseDTO<Product> findAll2(int page, int size, String sortBy, String sortDir);

    PageResponseDTO<Product> findAll2ByName(int page, int size, String sortBy, String sortDir,String name);
}