package com.code42.hashcode.cars.model;

/**
 * radu on 3/1/18 8:43 PM
 */
public class Ride {

    private Point from;
    private Point to;
    private int earliestStart;
    private int latestFinish;

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "from=" + from +
                ", to=" + to +
                ", earliestStart=" + earliestStart +
                ", latestFinish=" + latestFinish +
                '}';
    }
}
