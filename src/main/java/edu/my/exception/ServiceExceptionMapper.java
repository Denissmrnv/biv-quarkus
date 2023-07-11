package edu.my.exception;

import com.fasterxml.jackson.core.JsonParseException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<Exception> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ServiceExceptionMapper() {
    }

    public Response toResponse(Exception exception) {
        if (exception instanceof JsonParseException) {
            this.logger.error("Ошибка парсинга входящего JSON: ", exception);
            return Response.status(400).type("application/json").build();
        } else {
            this.logger.error("Непредвиденная ошибка работы сервиса: ", exception);
            return Response.status(500).type("application/json").build();
        }
    }
}
