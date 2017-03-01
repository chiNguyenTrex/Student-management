/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import entity.Transcript;
import java.util.ArrayList;

/**
 *
 * @author ChiNguyen
 */
public class Sort {

    public static void quickSort(ArrayList list, boolean bool) {
        if (bool) {
            incrementSort(list, 0, list.size() - 1);
        } else {
            decrementSort(list, 0, list.size() - 1);
        }
    }

    private static void incrementSort(ArrayList list, int left, int right) {
        int l = left, r = right;
        Transcript midTranscript = (Transcript) list.get((left + right) / 2);
        Transcript tempTranscript;

        double markMid = midTranscript.calculateAverageMark();

        do {

            while (((Transcript) list.get(l)).calculateAverageMark() < markMid && l < right) {
                l++;
            }

            while (markMid < ((Transcript) list.get(r)).calculateAverageMark() && r > left) {
                r--;
            }

            if (l <= r) {
                tempTranscript = (Transcript) list.get(l);

                list.set(l, list.get(r));

                list.set(r, tempTranscript);
                l++;
                r--;
            }

        } while (l <= r);

        if (left < r) {
            incrementSort(list, left, r);
        }

        if (l < right) {
            incrementSort(list, l, right);
        }

    }

    private static void decrementSort(ArrayList list, int left, int right) {
        int l = left, r = right;
        Transcript midTranscript = (Transcript) list.get((left + right) / 2);
        Transcript tempTranscript;

        double markMid = midTranscript.calculateAverageMark();

        do {

            while (((Transcript) list.get(l)).calculateAverageMark() > markMid && l < right) {
                l++;
            }

            while (markMid > ((Transcript) list.get(r)).calculateAverageMark() && r > left) {
                r--;
            }

            if (l <= r) {
                tempTranscript = (Transcript) list.get(l);

                list.set(l, list.get(r));

                list.set(r, tempTranscript);
                l++;
                r--;
            }

        } while (l <= r);

        if (left < r) {
            decrementSort(list, left, r);
        }

        if (l < right) {
            decrementSort(list, l, right);
        }

    }

}
