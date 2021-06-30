package com.EgyptianPyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PyramidCSVDAO implements PyramidsDAO{

    ArrayList<Pyramid> pyramids = new ArrayList<>();
    public PyramidCSVDAO() {
    }

    @Override
    public ArrayList<Pyramid> readPyramidsFromCsv() {

        BufferedReader br = null;

        try {
            br = new BufferedReader (new FileReader("/Users/abdelrahmanelghamry/IdeaProjects/EgyptianPyramids/pyramids.csv")); // read the first line from the text file which will be head column
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (line != null) {

//            System.out.println (line);

        }

        do {

            try {
                line = br.readLine(); // real data
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line != null) {

                String[] metadata = line.split(",");

                pyramids.add(createPyramid(metadata));
            }

            } while (line != null);

        return pyramids;
    }

    @Override
    public Pyramid createPyramid(String[] metadata) {

        return (new Pyramid(metadata[0],metadata[1],metadata[2],metadata[4],metadata[5],metadata[6],metadata[7],metadata[7],metadata[9]));
    }

    @Override
    public void removeEmptyNumerical() {
        IntStream.range(0, pyramids.size())
                .filter(i -> pyramids.get(i).getHeight().equals(""))
                .forEach(i -> pyramids.get(i).setHeight("0"));

        IntStream.range(0, pyramids.size())
                .filter(i -> pyramids.get(i).getVolume().equals(""))
                .forEach(i -> pyramids.get(i).setVolume("0"));

        IntStream.range(0, pyramids.size())
                .filter(i -> pyramids.get(i).getBase2().equals(""))
                .forEach(i -> pyramids.get(i).setBase2("0"));

        IntStream.range(0, pyramids.size())
                .filter(i -> pyramids.get(i).getBase1().equals(""))
                .forEach(i -> pyramids.get(i).setBase1("0"));

        IntStream.range(0, pyramids.size())
                .filter(i -> pyramids.get(i).getSlope().equals(""))
                .forEach(i -> pyramids.get(i).setSlope("0"));


    }

    @Override
    public void sortByHeight() {
        Collections.sort(pyramids, (p1, p2) -> (int) (Double.parseDouble(p1.getHeight()) - Double.parseDouble(p2.getHeight())));

    }


}
