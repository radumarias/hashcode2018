package com.code42.hashcode.cars.io;

import com.code42.hashcode.cars.model.Slice;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * radu on 2/24/18 3:21 PM
 */
public class SolutionWriter {

    private PrintWriter writer;
    private OutputStream os;

    public SolutionWriter(OutputStream os) {
        this.os = os;
    }

    public void writeNumSlices(int num) {
        ensureStreamIsInitiated();

        System.out.println(num);
        writer.println(num);
    }

    public void writeSlice(Slice slice) {
        ensureStreamIsInitiated();

        String line = String.format("%d %d %d %d", slice.getR1(), slice.getC1(), slice.getR2(), slice.getC2());
        System.out.println(line);
        writer.println(line);
    }

    public void end() {
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }

    private void ensureStreamIsInitiated() {
        if (writer == null) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
        }
    }
}