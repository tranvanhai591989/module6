package com.example.medical.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class PatientDto {
    private int id;
    @NotEmpty
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Wrong format")
    private String name;
}
