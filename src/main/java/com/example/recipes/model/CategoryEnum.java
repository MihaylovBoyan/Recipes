package com.example.recipes.model;

import java.util.Arrays;
import java.util.Optional;

public enum CategoryEnum {

    BREAKFAST, LUNCH, BRUNCH, DINNER;

    public static Optional<CategoryEnum> from(String value) {
        return Arrays.stream(CategoryEnum.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst();
    }
}