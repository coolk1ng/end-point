package com.coolk1ng.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数校验
 *
 * @author coolk1ng
 * @since 2023/5/17 09:34
 */
@RestController
@RequestMapping("/validate")
public class ValidatedController {

    @PostMapping("test1")
    public String test1(@RequestBody @Validated(value = {Groups.A.class}) Example example, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "ok...";
    }
}
