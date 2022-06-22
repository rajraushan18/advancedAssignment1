package com.nagarro.AdvanceJavaAssignment1.input;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import com.nagarro.AdvanceJavaAssignment1.model.*;

public class FolderReader implements Constants {

    public static HashSet<Tshirt> readFile(File file) {
        BufferedReader reader = null;
        HashSet<Tshirt> tshirt_Set = new HashSet<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                Tshirt t = manipulateLine(line);
                line = reader.readLine();
                tshirt_Set.add(t);
            }
        } catch (Exception e) {
            System.err.println("Could Not Read the File");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.err.println("Could Not Close the File");
                }
            }
        }
        return tshirt_Set;
    }

    private static Tshirt manipulateLine(String line) {

        StringTokenizer st = new StringTokenizer(line, "|");

        String id = st.nextToken();
        String name = st.nextToken();
        String color = st.nextToken();

       

        String gender_recommendation = st.nextToken();
        String size = st.nextToken();

        Double price = Double.parseDouble(st.nextToken());
        Double rating = Double.parseDouble(st.nextToken());
      
        String avail = st.nextToken();
        boolean availability;
        availability = avail.charAt(0) == 'Y';

       
        return new Tshirt(id, name, color, gender_recommendation, size,
                price, rating, availability);
    }
}
