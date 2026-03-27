package com.example.handler;

import com.example.exception.BaseExcepciton;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseExcepciton.class)
    public ResponseEntity<ApiError<?>> handleException(BaseExcepciton e, WebRequest request) {
       return ResponseEntity.badRequest().body(createApiError(e.getMessage(), request));
    }
    private String getHostName(WebRequest request) {
        return request.getHeader("host");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<String>> handleException(MethodArgumentNotValidException e, WebRequest request) {

        Map<String, List<String>> map=new HashMap<>();
        for (Object error : e.getBindingResult().getAllErrors()) {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            if (map.containsKey(fieldName)) {
                map.put(fieldName, addValue(map.get(fieldName), ((FieldError) error).getObjectName()));
            } else {
                map.put(fieldName, addValue(new java.util.ArrayList<>(), ((FieldError) error).getObjectName()));
            }
        }
       return ResponseEntity.badRequest().body(createApiError(e.getMessage(), request));
    }
    private List<String> addValue(List<String> li, String value) {
        li.add(value);
        return li;
    }
    public <E> ApiError<E> createApiError(E e, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        Exception<E> exception = new Exception<>();
        apiError.setStatus(500);
        exception.setPath(request.getDescription(false));
        exception.setCreateTime(new java.util.Date());
        exception.setHostName(getHostName(request));
        exception.setMessage(e);
        apiError.setException(exception);
        return apiError;
    }
}
