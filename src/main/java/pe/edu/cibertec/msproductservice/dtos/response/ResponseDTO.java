package pe.edu.cibertec.msproductservice.dtos.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private boolean success;
    private String message;
    private T data;
}