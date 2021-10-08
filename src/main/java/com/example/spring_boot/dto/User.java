package com.example.spring_boot.dto;

import com.example.spring_boot.anotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {

    @NotBlank
    private String name;

    @Min(value = 0)
    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 같지 않습니다. XXX-XXXX-XXXX")
    private String phoneNumber;

    @YearMonth(pattern = "yyyyMM")
    private String reqYearMonth;

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    // return 이 트루가 되면 정상으로 판단해서 valid 처리를 해준다.
//    @AssertTrue
//    public Boolean reqYearMonthValidation() {
//
//        try {
//            // LocalDate 를 사용하여 입력받은 reqYearMonth 를 파싱하고, yyyyMMdd 패턴이 아닐 경우 오류 발생 => catch 에서 return false 유효성 검사 실패
//            LocalDate localDate = LocalDate.parse(getReqYearMonth() +"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        }catch (Exception e){
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
