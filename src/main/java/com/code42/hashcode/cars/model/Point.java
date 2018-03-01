package com.code42.hashcode.cars.model;

/**
 * radu on 2/24/18 5:35 PM
 */
public class Point {
    private int row, col;

    public Point() {
    }

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
