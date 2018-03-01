package com.code42.hashcode.cars.model;

import java.util.Objects;

/**
 * radu on 2/24/18 5:28 PM
 */
public enum Ingredient {
    MUSHROOM('M'), TOMATO('T');

    private char value;

    Ingredient(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Ingredient get(char value) {
        for (Ingredient ingredient : values()) {
            if (ingredient.value == value) {
                return ingredient;
            }
        }

        throw new IllegalArgumentException(Objects.toString(value));
    }
}
