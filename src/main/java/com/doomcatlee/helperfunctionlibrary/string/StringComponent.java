package com.doomcatlee.helperfunctionlibrary.string;

import org.springframework.stereotype.Component;

@Component
public class StringComponent {

    String capFirstLetterInString(String str) {
        try {
            // If name has space in the middle, firstCap the second name.
            if (str.contains(" ")) {
                String[] nameSplit = str.split(" ");
                String firstName = capFirstLetterInString(nameSplit[0]);
                String secondName = capFirstLetterInString(nameSplit[1]);

                // Return with original white space in the middle
                return firstName + " " + secondName;
            }

            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        } catch (Exception ex) {
            return "";
        }
    }
}
