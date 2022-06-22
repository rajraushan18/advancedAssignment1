package com.nagarro.AdvanceJavaAssignment1.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import com.nagarro.AdvanceJavaAssignment1.model.*;

public class InputAcceptor implements Constants {

    public static UserInput enterInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String color, size, gender;
        int outputPreference;
      

        System.out.println("---------------------Tshirt checker---------------------");
        
       
        System.out.print("Color: ");
        while ((color = UserInputValidator.validateColor(br.readLine())) == null) {
            continue;
        }

        System.out.print("Size: ");
        while ((size = UserInputValidator.validateSize(br.readLine())) == null) {
            continue;
        }

        System.out.print("Gender (M/F/U) : ");
        while ((gender = UserInputValidator.validateGender(br.readLine())) == null) {
            continue;
        }

        System.out.print("Output preference(Sort by Price/Rating)):\n(Enter 1/2): ");
        while ((outputPreference = UserInputValidator
                .validateOutputPreference(Integer.parseInt(br.readLine()))) == 0) {
            continue;
        }

        
        return new UserInput(color, size, gender, outputPreference);
    }
}
