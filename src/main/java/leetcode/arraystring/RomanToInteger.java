package leetcode.arraystring;

import java.util.HashMap;

public class RomanToInteger {
    /**
     * LeetCode 13. Roman To Integer
     * Given:
     *  Takes in a string that represents a Roman Numeral and convert it to an integer
     *
     * Approach:
     *  Most Roman numerals can be calculated by taking each symbol convert them to a number and add them together
     *      Iterate through the symbols and find their values in a HashMap <Symbol, integer value>
     *
     * Considerations:
     *  Several numbers are use a reverse order to represent an integer
     *      4 - IV
     *      9 - IX
     *      40 - XL
     *      90 - XC
     *      400 - CD
     *      900 - CM
     *  This would require the iteration to check adjacent symbols to see if the string contains any of these combinations.
     *      Iteration would need to skip past related pairs
     * ------------------------------------------------------------------------------------------------------------------------------------
     * In a roman numeral, you can check a char at an index and check the next index, if the next is larger, you can subtract the current char.  This is a pattern of roman numerals.
     *  utilize a function that returns the value or the roman numeral, can use switch statements, faster than hashmap look-ups.
     */

    private HashMap<String, Integer> romanNumeralValues;

    public RomanToInteger() {
        this.romanNumeralValues = createRomanNumberValues();
    }

    // Time: O(n); Auxiliary space: O(1).
    // n = input.length(); fixed Roman-symbol table and constant-sized temporary substrings.
    public int romanToInteger (String input) {
        romanNumeralValues = createRomanNumberValues();
        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            String currRomanNumeral = String.valueOf(input.charAt(i));
            if(i < input.length() - 1) {
                if (currRomanNumeral.equals("I") || currRomanNumeral.equals("X") || currRomanNumeral.equals("C")) {
                    String adjacentPair = input.substring(i, i + 2);
                    if (romanNumeralValues.containsKey(adjacentPair)) {
                        total += romanNumeralValues.get(adjacentPair);
                        i++;
                    }
                    else {
                        total += romanNumeralValues.get(currRomanNumeral);
                    }
                } else {
                    total += romanNumeralValues.get(currRomanNumeral);
                }
            }
            else {
                total += romanNumeralValues.get(currRomanNumeral);
            }
        }
        return total;
    }

    /**
     * Notes:
     *      in the for loop can use an if or ternary statement to determine
     *      if nextValue should be found or just set as 0 if the index is out of bound.
     */

    // Time: O(n); Auxiliary space: O(1).
    // n = input.length(); fixed Roman-symbol table and constant-sized temporary substrings.
    public int romanToIntegerOptimal(String input) {
        int total = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            int currValue = romanValues(input.charAt(i));
            int nextValue = romanValues(input.charAt(i + 1));
            if(currValue < nextValue) {
                total -= currValue;
            }
            else {
            total += currValue;
            }
        }
        total += romanValues(input.charAt(input.length() - 1));

        return total;
    }
    // Time: O(1); Auxiliary space: O(1).
    // Fixed set of Roman symbols.
    private int romanValues(char currChar) {
        return switch (currChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    // Time: O(1); Auxiliary space: O(1).
    // Fixed set of Roman symbols.
    private HashMap<String, Integer> createRomanNumberValues(){
        HashMap<String, Integer> romanNumeralValues = new HashMap<>();
        romanNumeralValues.put("I", 1);
        romanNumeralValues.put("V", 5);
        romanNumeralValues.put("X", 10);
        romanNumeralValues.put("L", 50);
        romanNumeralValues.put("C", 100);
        romanNumeralValues.put("D", 500);
        romanNumeralValues.put("M", 1000);
        romanNumeralValues.put("IV", 4);
        romanNumeralValues.put("IX", 9);
        romanNumeralValues.put("XL", 40);
        romanNumeralValues.put("XC", 90);
        romanNumeralValues.put("CD", 400);
        romanNumeralValues.put("CM", 900);

        return romanNumeralValues;
    }

    public static void main(String[] args) {
        RomanToInteger sol = new RomanToInteger();
        System.out.println(sol.romanToInteger("III"));
        System.out.println(sol.romanToInteger("LVIII"));
        System.out.println(sol.romanToInteger("MCMXCIV"));

        System.out.println(sol.romanToIntegerOptimal("III"));
        System.out.println(sol.romanToIntegerOptimal("LVIII"));
        System.out.println(sol.romanToIntegerOptimal("MCMXCIV"));
    }
}
