package com.ermeson.crudspring.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull @Length(min = 5, max = 100) String name,
    @NotBlank @NotNull @Length(max = 10) @Pattern(regexp = "Front-end|Back-end|Full-stack") String category) {
}
