package com.lu2code.springdemo.mvc.validationdemo.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class courseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;
        if (theCode !=null){
            result= theCode.startsWith(coursePrefix);
        }else {
            result = true;
        }

        return result;
    }
}
