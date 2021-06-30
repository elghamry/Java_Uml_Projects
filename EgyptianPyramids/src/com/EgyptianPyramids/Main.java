package com.EgyptianPyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        PyramidsDAO DAO = new PyramidCSVDAO();

        ArrayList<Pyramid> pyramids = DAO.readPyramidsFromCsv();


        DAO.removeEmptyNumerical();

        DAO.sortByHeight();

//
//        Map<String,Integer> sitesMap = new HashMap<>();
//
//            sitesMap.put()


        System.out.println(listToMap(pyramids));



//                collect(Collectors.toMap(Pyramid::getSite);







//        System.out.println("pyramids :" + pyramids.toString());


//        for (Pyramid pyramid : pyramids) {
//            System.out.println("Pyramid no " + (pyramids.indexOf(pyramid) + 1));
//            System.out.println(pyramid.toString());

//            System.out.println("Pharaoh :" + pyramid.getPharaoh());
//            System.out.println("Ancient_name :" + pyramid.getAncient_name());
//            System.out.println("Base1 :" + pyramid.getBase1());
//            System.out.println("Base2 :" + pyramid.getBase2());
//            System.out.println("Height :" + pyramid.getHeight());
//            System.out.println("Site :" + pyramid.getSite());
//            System.out.println("Volume :" + pyramid.getVolume());
//            System.out.println("Slope :" + pyramid.getSlope());
//            System.out.println("-------------------------------------");


//        }
//  double volume_mean = 0.0;
//        for ( Pyramid pyramid : pyramids) {
//
//            if(!pyramid.getVolume().equals("")) {
//                System.out.println(pyramid.getVolume());
//                volume_mean = volume_mean + BigDecimal.valueOf(dpyramid.getVolume());
//            }
//
//
//        }
//        volume_mean = volume_mean/pyramids.size();
//        System.out.println("mean of Volumes is :"+volume_mean);
//
//    }
    }
//
    public static Map<String, Long> listToMap(List<Pyramid> pyramids) {
      Map<String, Long> pyramids_stream =  pyramids.stream().collect(Collectors.groupingBy(Pyramid::getSite,
                Collectors.counting()));


        return  pyramids_stream;
    }
}
