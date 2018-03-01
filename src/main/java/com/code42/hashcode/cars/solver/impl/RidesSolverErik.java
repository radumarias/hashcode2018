package com.code42.hashcode.cars.solver.impl;

import com.code42.hashcode.cars.io.SolutionWriter;
import com.code42.hashcode.cars.model.Point;
import com.code42.hashcode.cars.model.RequestModel;
import com.code42.hashcode.cars.model.Ride;
import com.code42.hashcode.cars.solver.Solver;

import java.util.*;

/**
 * Created by erik on 3/1/18
 */
public class RidesSolverErik implements Solver {

    private class Vehicle {

        Point currentPosition;
        int currentStep;

        Vehicle() {
            currentPosition = new Point(0,0);
            currentStep = 0;
        }
    }

    private class RideGainPair {

        Ride ride;
        int gain = 0;

        RideGainPair() {}

        RideGainPair(Ride ride, int gain) {
            this.ride = ride;
            this.gain = gain;
        }
    }

    private boolean[] rideDone;

    private RideGainPair selectMaximumRideBasedOnCurrentPosition(Vehicle vehicle, Ride[] rides, int steps, int bonus) {
        Map<Integer, Ride> rideMap = new HashMap<>();

        for (Ride ride : rides) {
            int sexyGain = 0;
            int distanceUntilRide = calculateDistanceUntilRide(vehicle, ride);

            if (!canVehicleDoRide(vehicle, ride, steps, distanceUntilRide) || rideDone[ride.getId()]) {
                continue; //vehicle cannot do this ride
            }

            sexyGain+=ride.getDistance();

            if (distanceUntilRide == ride.getEarliestStart()) {
                sexyGain+=bonus;
            }
            rideMap.put(sexyGain, ride);
        }

        if (rideMap.isEmpty()) {
            return null;
        } else {
            Integer maxKey = Collections.max(rideMap.keySet());
            return new RideGainPair(rideMap.get(maxKey), maxKey);
        }
    }

    private int calculateDistanceUntilRide(Vehicle vehicle, Ride ride) {
        //System.out.println("" + (Math.abs(vehicle.currentPosition.getCol() - ride.getFrom().getCol()) + Math.abs(vehicle.currentPosition.getRow() - ride.getFrom().getRow())));
        return Math.abs(vehicle.currentPosition.getCol() - ride.getFrom().getCol()) +
                Math.abs(vehicle.currentPosition.getRow() - ride.getFrom().getRow());
    }

    private boolean allRidesDone() {
        for (boolean b : rideDone) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private Ride getNextAvailableRide(Ride[] rides, Vehicle vehicle, int steps) {
        for (Ride r : rides) {
            if (!rideDone[r.getId()] && canVehicleDoRide(vehicle, r, steps, calculateDistanceUntilRide(vehicle, r))) {
                return r;
            }
        }

        return null;
    }

    private boolean canVehicleDoRide(Vehicle vehicle, Ride ride, int steps, int distanceUntilRide) {
        return vehicle.currentStep + distanceUntilRide + ride.getDistance() <= steps;
    }

    @Override
    public void solve(RequestModel requestModel, SolutionWriter writer) {
        Vehicle[] vehicles = new Vehicle[requestModel.getVehicles() + 1];
        Arrays.fill(vehicles, new Vehicle());
        rideDone = new boolean[requestModel.getRidesList().length];

        Map<Integer, List<Integer>> solutionMap = new HashMap<>();

        //while (true) {

            int vehicleId = 0;
            int steps;
            for (Vehicle vehicle : vehicles) {
                steps = requestModel.getSteps();
                vehicle.currentStep = 0;
                Map<Integer, List<Integer>> rideMap = new HashMap<>(); //gains and list of rides
                while (getNextAvailableRide(requestModel.getRidesList(), vehicle, steps) != null) {
                    RideGainPair rideGainPair;
                    List<Integer> rideIdsList = new ArrayList<>();
                    int totalGain = 0;
                    do {
                        rideGainPair = selectMaximumRideBasedOnCurrentPosition(vehicle, requestModel.getRidesList(),
                                steps, requestModel.getBonus());

                        if (rideGainPair != null) {
                            rideDone[rideGainPair.ride.getId()] = true;
                            rideIdsList.add(rideGainPair.ride.getId());
                            vehicle.currentStep += calculateDistanceUntilRide(vehicle, rideGainPair.ride) +
                                    rideGainPair.ride.getDistance();
                            vehicle.currentPosition = rideGainPair.ride.getTo();
                            totalGain += rideGainPair.gain;
                        }
                    } while (rideGainPair != null);
                    rideMap.put(totalGain, rideIdsList);
                }

                if (!rideMap.isEmpty()) {
                    Integer maxKey = Collections.max(rideMap.keySet());
                    solutionMap.put(vehicleId++, rideMap.get(maxKey));
                }

            }
        //}

        for (List<Integer> list : solutionMap.values()) {
            writer.write(list.toArray(new Integer[0]));
        }

        writer.end();
    }
}
