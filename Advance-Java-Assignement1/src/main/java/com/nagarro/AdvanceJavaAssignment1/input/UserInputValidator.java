package com.nagarro.AdvanceJavaAssignment1.input;

import java.util.HashSet;

import com.nagarro.AdvanceJavaAssignment1.model.*;
import com.nagarro.AdvanceJavaAssignment1.controller.Utility;

/*
 * UserInput
 */
public class UserInputValidator implements Constants {
   
    public static String validateColor(String clr) {
        synchronized (Utility.tshirtsInfo) {
            for (HashSet<Tshirt> tshirtSet : Utility.tshirtsInfo.values()) {
                for (Tshirt t : tshirtSet) {
                    if (t.getColor().equalsIgnoreCase(clr))
                        return t.getColor();
                }
            }
        }
        System.err.print("No Tshirts are available for given color, Kindly Try Different Color : ");
        return null;
    }

    public static String validateSize(String size) {
        synchronized (Utility.tshirtsInfo) {
            for (HashSet<Tshirt> tshirtSet : Utility.tshirtsInfo.values()) {
                for (Tshirt t : tshirtSet) {
                    if (t.getSize().equalsIgnoreCase(size))
                        return t.getSize();
                }
            }
        }
        System.err.print("No Tshirts are available for given size, Kindly Try Different Size : ");
        return null;
    }

    public static String validateGender(String gender) {
        synchronized (Utility.tshirtsInfo) {
            for (HashSet<Tshirt> tshirtSet : Utility.tshirtsInfo.values()) {
                for (Tshirt t : tshirtSet) {
                    if (t.getGenderRecommendation().equalsIgnoreCase(gender))
                        return t.getGenderRecommendation();
                }
            }
        }
        System.err.print("No Tshirts are available for given gender, Kindly Try Different Gender : ");
        return null;
    }


    public static int validateOutputPreference(int i) {
        if ((i == 1) || (i == 2))
            return i;
        else {
            System.err.print("Output preference entered Inappropriately, Enter Again : ");
            return 0;
        }
    }
}