package com.ermeson.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.ermeson.crudspring.dto.CourseDTO;
import com.ermeson.crudspring.enums.Category;
import com.ermeson.crudspring.model.Course;

@Component
public class CourseMapper {
    
    public CourseDTO toDTO(Course course) {
        if(course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
    }

    public Course toEntity(CourseDTO courseDTO) {
        if(courseDTO == null) {
            return null;
        }

        Course course = new Course();
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));
        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null)
            return null;
        return switch (value) {
            case "Front-end" -> Category.FRONTEND;
            case "Back-end" -> Category.BACKEND;
            case "Full-stack" -> Category.FULLSTACK;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }

}
