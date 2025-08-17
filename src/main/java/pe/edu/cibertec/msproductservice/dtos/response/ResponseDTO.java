package pe.edu.cibertec.msproductservice.dtos.response;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private LocalDateTime timestamp;
    private boolean success;
    private String message;
    private T data;
    private String path;
    private int status;
}