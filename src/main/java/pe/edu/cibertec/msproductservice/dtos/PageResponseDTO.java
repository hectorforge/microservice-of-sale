package pe.edu.cibertec.msproductservice.dtos;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponseDTO<T> {
    private List<T> items;
    private PaginationMeta pagination;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PaginationMeta {
        private int page;
        private int size;
        private int totalPages;
        private long totalElements;
        private boolean first;
        private boolean last;
    }
}