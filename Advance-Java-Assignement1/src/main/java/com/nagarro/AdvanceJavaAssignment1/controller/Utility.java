package com.nagarro.AdvanceJavaAssignment1.controller;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.nagarro.AdvanceJavaAssignment1.input.*;
import com.nagarro.AdvanceJavaAssignment1.model.*;

public class Utility {

    public static final HashMap<String, HashSet<Tshirt>> tshirtsInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Tshirt> info = new ArrayList<>();
        String choice;
        UserInput uiObj;

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);

        do {
            uiObj = InputAcceptor.enterInput();
            info.clear();
            synchronized (Utility.tshirtsInfo) {
                for (HashSet<Tshirt> set : tshirtsInfo.values()) {
                    for (Tshirt t : set) {
                        if (t.getColor().equalsIgnoreCase(uiObj.getColor()) && t.getSize().equalsIgnoreCase(uiObj.getSize())
                                											&& t.getGenderRecommendation().equalsIgnoreCase(uiObj.getGenderRecommendation())
                                											&& t.isAvailability())
                            												info.add(t);
                    }
                }
            }
            if (uiObj.getOutputPreference() == 1)
                Collections.sort(info, new TshirtPriceComparator());
            else
                Collections.sort(info,new TshirtRatingComparator());
            
            System.out.println("\n-----------------------------------");
            System.out.print("Result: ");
            if(!info.isEmpty()) {
            	System.out.print("\n");
		        for (Tshirt t : info) {
		            System.out.println(t);
		        }
            }else {
            	System.err.println("No matching T-Shirt Found");
            }
            System.out.println("-----------------------------------");
            System.out.print("\nWant to Exit (Y/N): ");
            while (!((choice = br.readLine()).equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")))
                System.out.print("Please try again:");
        } while (choice.equalsIgnoreCase("n"));
        System.out.println("----Thank you-----");
        service.shutdown();
    }

}
