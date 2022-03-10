package micronaut.crud.exception;

import io.micronaut.http.HttpStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorResponse {
    private HttpStatus status;
    private String message;
    private long timeStamp;
}
