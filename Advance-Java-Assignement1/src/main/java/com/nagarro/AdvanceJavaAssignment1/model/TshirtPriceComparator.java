package com.nagarro.AdvanceJavaAssignment1.model;

import java.util.Comparator;

public class TshirtPriceComparator implements Comparator<Tshirt> {
    @Override
    public int compare(Tshirt arg0, Tshirt arg1) {
        return (int) (arg0.getPrice() - arg1.getPrice());
    }
}
