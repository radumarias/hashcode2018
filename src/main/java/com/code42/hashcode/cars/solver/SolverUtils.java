package com.code42.hashcode.cars.solver;

import com.code42.hashcode.cars.model.RequestModel;
import com.code42.hashcode.cars.model.Slice;

/**
 * radu on 2/24/18 5:19 PM
 */
public class SolverUtils {

    public enum SliceValidResult {
        OK, INVALID_COORDS, INVALID_SIZE, INVALID_INGREDIENTS;
    }

    public static SliceValidResult check(Slice slice, RequestModel requestModel) {
        // Coords.
        if (!isValidCoords(slice)) return SliceValidResult.INVALID_COORDS;

        // Size.
        if (!isValidSize(slice, requestModel)) return SliceValidResult.INVALID_SIZE;

        // Ingredients.
        if (!isValidIngredients(slice, requestModel)) return SliceValidResult.INVALID_INGREDIENTS;

        return SliceValidResult.OK;
    }

    private static boolean isValidIngredients(Slice slice, RequestModel requestModel) {
        boolean enoughIngredients = false;
        int countMushroom = 0;
        int countTomato = 0;
        for (int i = slice.getR1(); i <= slice.getR2(); i++) {
            if (countMushroom >= requestModel.getMinIngredients() && countTomato >= requestModel.getMinIngredients()) {
                enoughIngredients = true;
                break;
            }
            for (int j = slice.getC1(); j <= slice.getC2(); j++) {
                switch (requestModel.getPizzaCells()[i][j]) {
                    case TOMATO:
                        countTomato++;
                        break;
                    case MUSHROOM:
                        countMushroom++;
                }
            }
        }
        if (enoughIngredients) {
            return true;
        }

        return false;
    }

    public static boolean isValidSize(Slice slice, RequestModel requestModel) {
        if (countCells(slice) > requestModel.getMaxCells()) {
            return false;
        }

        return true;
    }

    public static boolean isValidCoords(Slice slice) {
        if (slice.getR1() > slice.getR2()) {
            return false;
        }
        if (slice.getC1() > slice.getC2()) {
            return false;
        }

        return true;
    }

    public static int countCells(Slice slice) {
        return (slice.getR2() - slice.getR1() + 1) * (slice.getC2() - slice.getC1() + 1);
    }
}
