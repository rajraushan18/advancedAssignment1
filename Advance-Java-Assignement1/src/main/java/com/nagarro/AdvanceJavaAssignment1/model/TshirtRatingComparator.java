package com.nagarro.AdvanceJavaAssignment1.model;

import java.util.Comparator;

public class TshirtRatingComparator implements Comparator<Tshirt> {

    @Override
    public int compare(Tshirt a, Tshirt b) {
        double x = b.getRating() - a.getRating();
        if (x < 0)
            return -1;
        else if (x > 0)
            return 1;
        else
            return 0;
    }
}
