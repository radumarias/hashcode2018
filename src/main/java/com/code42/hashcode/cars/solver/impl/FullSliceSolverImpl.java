//package com.code42.hashcode.cars.solver.impl;
//
//import com.code42.hashcode.cars.io.SolutionWriter;
//import com.code42.hashcode.cars.model.RequestModel;
//import com.code42.hashcode.cars.model.Slice;
//import com.code42.hashcode.cars.solver.Solver;
//import com.code42.hashcode.cars.solver.SolverUtils;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * radu on 2/24/18 4:28 PM
// */
//public class FullSliceSolverImpl implements Solver {
//
//    private enum Direction {
//        HORIZ, VERT;
//    }
//
//    private interface SliceTransformer {
//        Slice expandOrCreate(Slice slice, int chunk, RequestModel requestModel);
//    }
//
//    private Map<Direction, SliceTransformer> sliceFactories;
//
//    public FullSliceSolverImpl() {
//        sliceFactories = new HashMap<Direction, SliceTransformer>() {{
//            put(Direction.VERT, new VertSliceTransformer());
//            put(Direction.HORIZ, new HorizSliceTransformer());
//        }};
//    }
//
//    public void solve(RequestModel requestModel, SolutionWriter writer) {
//        List<Slice> vertSlices = solve(Direction.VERT, requestModel);
//        List<Slice> horizSlices = solve(Direction.HORIZ, requestModel);
//
//        // Compare solutions and use the best one.
//        int vertSum = vertSlices.stream().mapToInt(SolverUtils::countCells).sum();
//        int horizSum = horizSlices.stream().mapToInt(SolverUtils::countCells).sum();
//
//        List<Slice> bestSlices = vertSum > horizSum ? vertSlices : horizSlices;
//        writeSolution(bestSlices, writer);
//    }
//
//    private void writeSolution(List<Slice> slices, SolutionWriter writer) {
//        writer.writeNumSlices(slices.size());
//        for (Slice slice : slices) {
//            writer.writeSlice(slice);
//        }
//        writer.end();
//    }
//
//    private List<Slice> solve(Direction direction, RequestModel requestModel) {
//        List<Slice> slices = new ArrayList<>();
//
//        int chunk = 0;
//        Slice validSlice = null;
//        Slice trySlice = null;
//
//        while (chunk < (direction == Direction.VERT ? requestModel.getCols() : requestModel.getRows())) {
//            // Create new try slice.
//            trySlice = sliceFactories.get(direction).expandOrCreate(trySlice, chunk, requestModel);
//
//            SolverUtils.SliceValidResult check = SolverUtils.check(trySlice, requestModel);
//            if (check == SolverUtils.SliceValidResult.INVALID_COORDS) {
//                throw new IllegalArgumentException(String.format("Invalid slice coords [%s].", trySlice.toString()));
//            } else if (check == SolverUtils.SliceValidResult.OK) {
//                // Use this as the new valid slice and try to create a larger one.
//                validSlice = new Slice(trySlice);
//            } else if (check == SolverUtils.SliceValidResult.INVALID_SIZE) {
//                // To large, check if we have a valid slice from prev step, add that as a solution and reset the slice.
//                if (validSlice != null) {
//                    slices.add(validSlice);
//                    validSlice = null;
//
//                    // Create new try slice with the current chunk.
//                    trySlice = sliceFactories.get(direction).expandOrCreate(null, chunk, requestModel);
//                }
//            }
//            // For all other cases add a new chunk.
//
//            // Move to next chunk;
//            chunk++;
//        }
//
//        return slices;
//    }
//
//    private static class VertSliceTransformer implements SliceTransformer {
//
//        @Override
//        public Slice expandOrCreate(Slice slice, int chunk, RequestModel requestModel) {
//            if (slice == null) {
//                int maxRows = requestModel.getRows() < requestModel.getMaxCells() ? requestModel.getRows() : requestModel.getMaxCells();
//                slice = new Slice(0, chunk, maxRows - 1, chunk);
//            } else {
//                slice.setC2(chunk);
//            }
//
//            return slice;
//        }
//    }
//
//    private static class HorizSliceTransformer implements SliceTransformer {
//
//        @Override
//        public Slice expandOrCreate(Slice slice, int chunk, RequestModel requestModel) {
//            if (slice == null) {
//                int maxCols = requestModel.getCols() < requestModel.getMaxCells() ? requestModel.getCols() : requestModel.getMaxCells();
//                slice = new Slice(chunk, 0, chunk, maxCols - 1);
//            } else {
//                slice.setR2(chunk);
//            }
//
//            return slice;
//        }
//    }
//}
