package micronaut.crud.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Produces
@Singleton
@Slf4j
@Requires(classes = {IllegalArgumentException.class, ExceptionHandler.class})
public class IllegalArgumentExceptionHandler
        implements ExceptionHandler<IllegalArgumentException, HttpResponse<ApiErrorResponse>> {

    @Override
    public HttpResponse<ApiErrorResponse> handle(HttpRequest request, IllegalArgumentException exception) {
        log.info(exception.getMessage());

        ApiErrorResponse response = ApiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();

        return HttpResponse.serverError(response).
                status(response.getStatus());
    }
}
