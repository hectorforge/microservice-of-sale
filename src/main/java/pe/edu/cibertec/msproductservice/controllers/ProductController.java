package pe.edu.cibertec.msproductservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.msproductservice.dtos.PageResponseDTO;
import pe.edu.cibertec.msproductservice.dtos.response.ResponseDTO;
import pe.edu.cibertec.msproductservice.models.Product;
import pe.edu.cibertec.msproductservice.services.IProductService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/v1")
    public ResponseEntity<ResponseDTO<Page<Product>>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "idProduct") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            HttpServletRequest request) {

        return ResponseEntity.ok(
                ResponseDTO.<Page<Product>>builder()
                        .timestamp(LocalDateTime.now())
                        .success(true)
                        .message("Productos encontrados")
                        .data(productService.findAll(page, size, sortBy, sortDir))
                        .path(request.getRequestURI())
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/v2")
    public ResponseEntity<ResponseDTO<PageResponseDTO<Product>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idProduct") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            HttpServletRequest request
    ) {
        PageResponseDTO<Product> pageResponse = productService.findAll2(page, size, sortBy, sortDir);

        ResponseDTO<PageResponseDTO<Product>> response = ResponseDTO.<PageResponseDTO<Product>>builder()
                .timestamp(LocalDateTime.now())
                .success(true)
                .message("Productos obtenidos correctamente")
                .data(pageResponse)
                .path(request.getRequestURI())
                .status(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<PageResponseDTO<Product>>> searchProducts(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            HttpServletRequest request
    ) {
        PageResponseDTO<Product> response = productService.findAll2ByName(page, size, sortBy, sortDir,name);

        return ResponseEntity.ok(
                ResponseDTO.<PageResponseDTO<Product>>builder()
                        .timestamp(LocalDateTime.now())
                        .success(true)
                        .message("Busqueda realizada con exito")
                        .data(response)
                        .path(request.getRequestURI())
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/category")
    public ResponseEntity<ResponseDTO<PageResponseDTO<Product>>> getAllProductsByCategoryName(
            @RequestParam(defaultValue = "") String categoryName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            HttpServletRequest request
    ) {
        PageResponseDTO<Product> response = productService.findAll2ByCategory(page, size, sortBy, sortDir,categoryName);

        return ResponseEntity.ok(
                ResponseDTO.<PageResponseDTO<Product>>builder()
                        .timestamp(LocalDateTime.now())
                        .success(true)
                        .message("Busqueda realizada con exito")
                        .data(response)
                        .path(request.getRequestURI())
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

}