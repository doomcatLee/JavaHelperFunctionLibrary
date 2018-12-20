package com.doomcatlee.helperfunctionlibrary.sorting;

import com.doomcatlee.helperfunctionlibrary.CustomObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComponent {

    void sortObjectsByDescendingOrder() {
        List<CustomObject> customList = new ArrayList<>();

        Collections.sort(customList, new Comparator<CustomObject>() {
            @Override
            public int compare(CustomObject lhs, CustomObject rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.index > rhs.index ? -1 : (lhs.index < rhs.index) ? 1 : 0;
            }
        });
    }

    void sortObjectsByAscendingOrder() {
        List<CustomObject> customList = new ArrayList<>();

        Collections.sort(customList, new Comparator<CustomObject>() {
            @Override
            public int compare(CustomObject lhs, CustomObject rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.index < rhs.index ? -1 : (lhs.index > rhs.index) ? 1 : 0;
            }
        });

    }
}
