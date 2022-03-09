package com.jonas.crudomie.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private int code;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<String> error;
}
