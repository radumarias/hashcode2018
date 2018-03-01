package com.code42.hashcode.cars.model;

/**
 * radu on 2/24/18 3:25 PM
 */
public class RequestModel {

    private int rows;
    private int cols;
    private int minIngredients;
    private int maxCells;
    private Ingredient[][] pizzaCells;

    public RequestModel() {
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getMinIngredients() {
        return minIngredients;
    }

    public void setMinIngredients(int minIngredients) {
        this.minIngredients = minIngredients;
    }

    public int getMaxCells() {
        return maxCells;
    }

    public void setMaxCells(int maxCells) {
        this.maxCells = maxCells;
    }

    public Ingredient[][] getPizzaCells() {
        return pizzaCells;
    }

    public void setPizzaCells(Ingredient[][] pizzaCells) {
        this.pizzaCells = pizzaCells;
    }
}
