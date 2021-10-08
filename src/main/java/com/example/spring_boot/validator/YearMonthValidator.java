package com.example.spring_boot.validator;

import com.example.spring_boot.anotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ConstraintValidator<우리가 원하는 어노테이션, 어노테이션에 들어가는 값>
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    // 확인해야 되는 값
    private String pattern;


    @Override
    public void initialize(YearMonth constraintAnnotation) {
        // 초기화 해주는 값으로 어노테이션의 패턴 값을 가져온다.
        // yyyyMM 의 값이 pattern 에 초기화 된다는 뜻이다.
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println(value+"26");

        // value 값이 yyyyMM 값이다.
        try {
            // LocalDate 를 사용하여 입력받은 reqYearMonth 를 파싱하고, yyyyMM 패턴이 아닐 경우 오류 발생 => catch 에서 return false 유효성 검사 실패
            LocalDate localDate = LocalDate.parse(value+"26", DateTimeFormatter.ofPattern(this.pattern));
            System.out.println(localDate);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
