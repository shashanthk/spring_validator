package com.shashanth.spring.validator.validators;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ValidatorProperties {

    @Value("${alphabets.regexp}")
    private String alphabetsRegex;
    @Value("${alphanumeric.regexp}")
    private String alphaNumericRegex;
    @Value("${numeric.regexp}")
    private String numericRegex;
    @Value("${email.regexp}")
    private String emailRegex;
    @Value("${filepath.regexp}")
    private String filePathRegex;

}
