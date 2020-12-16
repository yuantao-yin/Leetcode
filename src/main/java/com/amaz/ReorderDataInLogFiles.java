package com.amaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReorderDataInLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
           String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cnt = split1[1].compareTo(split2[1]);
                if (cnt == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return cnt;
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }

    public static void main(String[] args) {
        ReorderDataInLogFiles.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6",
            "let2 own kit dig","let3 art zero"});
    }
}
