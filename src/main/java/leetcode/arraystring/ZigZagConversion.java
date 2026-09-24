package leetcode.arraystring;

public class ZigZagConversion {
    // Time: No finite bound for all valid inputs; Auxiliary space: No finite bound for all valid inputs.
    // For numRows = 1 and s.length() > 1, index never advances and builder keeps growing. Incomplete algorithm.
    public String convert(String s, int numRows) {
        StringBuilder converted = new StringBuilder();
        int currRow = 0;
        int currIndex = 0;
        while (currIndex != s.length() - 1) {
            if (currIndex >= s.length()) {
                currRow += 1;
                currIndex = currRow;
            }
            if (currIndex == s.length() - 1) {
                converted.append(s.charAt(currIndex));
                break;
            }
            //edge rows
            if (currRow == 0 || currRow == numRows - 1) {
                converted.append(s.charAt(currIndex));
                currIndex += (2*numRows - 2);
            }
            else {
                converted.append(s.charAt(currIndex));
                currIndex += (numRows - 1);
            }
        }
        return converted.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZagConversion sol = new ZigZagConversion();
        System.out.println(sol.convert(s, 3));
    }
}
