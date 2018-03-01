package com.code42.hashcode.cars.io;

import com.code42.hashcode.cars.model.Ingredient;
import com.code42.hashcode.cars.model.RequestModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * radu on 2/24/18 3:20 PM
 */
public class RequestReader {

    public RequestModel read(InputStream is) throws IOException {
        RequestModel model = new RequestModel();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        String[] items = line.split(" ");
        model.setRows(Integer.parseInt(items[0]));
        model.setCols(Integer.parseInt(items[1]));
        model.setMinIngredients(Integer.parseInt(items[2]));
        model.setMaxCells(Integer.parseInt(items[3]));
        model.setPizzaCells(new Ingredient[model.getRows()][model.getCols()]);

        for (int i = 0; i < model.getRows(); i++) {
            line = br.readLine();
            for (int j = 0; j < model.getCols(); j++) {
                model.getPizzaCells()[i][j] = Ingredient.get(line.charAt(j));
            }
        }

        return model;
    }
}
