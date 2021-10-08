package com.example.spring_boot.dto;

import com.example.spring_boot.anotation.YearMonth;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
public class User {

//    @NotEmpty
//    @Size(min=1, max=10)
    private String name;

//    @Min(value = 1)
//    @NotNull
    private Integer age;
}
