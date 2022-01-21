package com.example.validate_form.dto;

import javax.validation.constraints.*;

public class UserDto {
    private int id;
    @NotBlank(message = "không để trống")
    @Size(min=5,max = 45 ,message = "first name từ 5 đến 45 kí tự")
    private String firstName;
    @NotBlank(message = " không để trống")
    @Size(min=5,max = 45)
    private String lastName;
    @NotBlank(message = "số điện thoại không đươc để trống ")
    @Pattern(regexp = "\\d{10,11}", message = "phone không đúng định dạng")
    private String phoneNumber;
    @NotNull(message = "Không được để trống")
    @Min(18)
    private Integer age;
    @NotBlank(message = "Không được để trống")
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(@NotBlank(message = "không để trống") @Size(min = 5, max = 45, message = "first name từ 5 đến 45 kí tự") String firstName, @NotBlank(message = " không để trống") @Size(min = 5, max = 45) String lastName, @NotBlank(message = "số điện thoại không đươc để trống ")
    @Pattern(regexp = "\\d{10,11}", message = "phone không đúng định dạng") String phoneNumber, @NotBlank(message = "Không được để trống") @Min(18) Integer age, @NotBlank(message = "Không được để trống") @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
