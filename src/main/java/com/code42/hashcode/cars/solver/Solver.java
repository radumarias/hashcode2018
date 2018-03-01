package com.code42.hashcode.cars.solver;

import com.code42.hashcode.cars.io.SolutionWriter;
import com.code42.hashcode.cars.model.RequestModel;

/**
 * radu on 2/24/18 3:20 PM
 */
public interface Solver {

    void solve(RequestModel requestModel, SolutionWriter writer);
}
