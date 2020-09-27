package com.flang.fb;

/*
One simple way to encrypt a string is to "rotate" every alphanumeric character
by a certain amount. Rotating a character means replacing it with another character
that is a certain number of steps away in normal alphabetic or numerical order.

For example, if the string "Zebra-493?" is rotated 3 places, the resulting string
is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters
higher (wrapping around from Z to A), and every numeric character replaced with the
character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric
characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
 */
public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        if (input == null || input.length() == 0) return null;
        if (rotationFactor == 0) return input;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char cipher = (char) ((c - 'A' + rotationFactor) % 26 + 'A');
                sb.append(cipher);
            } else if (Character.isLowerCase(c)) {
                char cipher = (char) ((c - 'a' + rotationFactor) % 26 + 'a');
                sb.append(cipher);
            } else if (Character.isDigit(c)) {
                char cipher = (char) ((c - '0' + rotationFactor) % 10 + '0');
                sb.append(cipher);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
