package pe.edu.cibertec.msproductservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.msproductservice.dtos.PageResponseDTO;
import pe.edu.cibertec.msproductservice.dtos.response.ResponseDTO;
import pe.edu.cibertec.msproductservice.models.Product;
import pe.edu.cibertec.msproductservice.repositories.ProductRepository;
import pe.edu.cibertec.msproductservice.services.IProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> findAll(
            int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }

    @Override
    public PageResponseDTO<Product> findAll2(
            int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productRepository.findAll(pageable);

        return PageResponseDTO.<Product>builder()
                .items(productPage.getContent())
                .pagination(PageResponseDTO.PaginationMeta.builder()
                        .page(productPage.getNumber())
                        .size(productPage.getSize())
                        .totalPages(productPage.getTotalPages())
                        .totalElements(productPage.getTotalElements())
                        .first(productPage.isFirst())
                        .last(productPage.isLast())
                        .build())
                .build();
    }

    @Override
    public PageResponseDTO<Product> findAll2ByName(
            int page, int size, String sortBy, String sortDir,String name) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage = productRepository.findByNameContainingIgnoreCase(name, pageable);

        return PageResponseDTO.<Product>builder()
                .items(productPage.getContent())
                .pagination(PageResponseDTO.PaginationMeta.builder()
                        .page(productPage.getNumber())
                        .size(productPage.getSize())
                        .totalPages(productPage.getTotalPages())
                        .totalElements(productPage.getTotalElements())
                        .first(productPage.isFirst())
                        .last(productPage.isLast())
                        .build())
                .build();
    }

    @Override
    public PageResponseDTO<Product> findAll2ByCategory(
            int page, int size, String sortBy, String sortDir, String categoryName) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productRepository.findByCategory_NameIgnoreCase(categoryName, pageable);

        return PageResponseDTO.<Product>builder()
                .items(productPage.getContent())
                .pagination(PageResponseDTO.PaginationMeta.builder()
                        .page(productPage.getNumber())
                        .size(productPage.getSize())
                        .totalPages(productPage.getTotalPages())
                        .totalElements(productPage.getTotalElements())
                        .first(productPage.isFirst())
                        .last(productPage.isLast())
                        .build())
                .build();
    }

    @Override
    public PageResponseDTO<Product> findAll2ByProductNameAndCategory(
            int page, int size, String sortBy, String sortDir,
            String categoryName, String name) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage = productRepository.findByCategoryAndProductName(
                categoryName,
                name,
                pageable
        );

        return PageResponseDTO.<Product>builder()
                .items(productPage.getContent())
                .pagination(PageResponseDTO.PaginationMeta.builder()
                        .page(productPage.getNumber())
                        .size(productPage.getSize())
                        .totalPages(productPage.getTotalPages())
                        .totalElements(productPage.getTotalElements())
                        .first(productPage.isFirst())
                        .last(productPage.isLast())
                        .build())
                .build();
    }

}