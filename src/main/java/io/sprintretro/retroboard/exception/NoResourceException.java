package io.sprintretro.retroboard.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoResourceException extends RuntimeException {
    String resourceName;
    String fieldName;
    Long fieldValue;

    public NoResourceException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("Sorry, the %s with the %s %s could not be found. Input is incorrect.Please check the input and try again.", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
