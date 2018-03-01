package com.code42.hashcode.cars;

import com.code42.hashcode.cars.io.RequestReader;
import com.code42.hashcode.cars.io.SolutionWriter;
import com.code42.hashcode.cars.model.RequestModel;
import com.code42.hashcode.cars.solver.Solver;
import com.code42.hashcode.cars.solver.SolverImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * radu on 2/24/18 3:21 PM
 */
public class Mind {

    private RequestReader reader;
    private Solver solver;

    public Mind() {
        reader = new RequestReader();
        solver = new SolverImpl();
    }

    public void doYouMagic(InputStream in, OutputStream out) throws IOException {
        SolutionWriter writer = new SolutionWriter(out);
        RequestModel requestModel = reader.read(in);
        System.out.println("requestModel = " + requestModel);
        solver.solve(requestModel, writer);
    }
}
