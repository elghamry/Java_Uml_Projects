package com.EgyptianPyramids;

import java.util.ArrayList;
import java.util.List;

public interface PyramidsDAO {

    public ArrayList<Pyramid> readPyramidsFromCsv();
    public Pyramid createPyramid(String [] metadata);
    public void removeEmptyNumerical();

    public void sortByHeight();
}
