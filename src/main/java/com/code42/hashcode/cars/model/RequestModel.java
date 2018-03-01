package com.code42.hashcode.cars.model;

/**
 * radu on 2/24/18 3:25 PM
 */
public class RequestModel {

    private int rows;
    private int cols;
    private int vehicles;
    private int numRides;
    private int bonus;
    private int steps;
    private Ride[] ridesList;

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

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public int getNumRides() {
        return numRides;
    }

    public void setNumRides(int numRides) {
        this.numRides = numRides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Ride[] getRidesList() {
        return ridesList;
    }

    public void setRidesList(Ride[] ridesList) {
        this.ridesList = ridesList;
    }
}
