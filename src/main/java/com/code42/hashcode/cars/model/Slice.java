package com.code42.hashcode.cars.model;

/**
 * radu on 2/24/18 5:15 PM
 */
public class Slice {

    private int r1, c1, r2, c2;

    public Slice() {
    }

    public Slice(Slice slice) {
        this(slice.getR1(), slice.getC1(), slice.getR2(), slice.getC2());
    }

    public Slice(int r1, int c1, int r2, int c2) {
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    @Override
    public String toString() {
        return "Slice{" +
                "r1=" + r1 +
                ", c1=" + c1 +
                ", r2=" + r2 +
                ", c2=" + c2 +
                '}';
    }
}
