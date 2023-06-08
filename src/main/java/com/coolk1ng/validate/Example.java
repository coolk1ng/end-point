package com.coolk1ng.validate;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author coolk1ng
 * @since 2023/5/17 09:36
 */
@Data
public class Example {
    @NotNull
    private String id;
    @NotNull
    @Length(min = 10, groups = {Groups.A.class})
    private String name;
    private Integer age;
    private String address;
    @Email(groups = {Groups.A.class})
    private String email;
    private String phone;
}
