package leetcode.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    // Time: O(n + C) on terminating valid-width inputs; Auxiliary space: O(W), excluding output.
    // n = word count, C = total input characters, W = maxWidth. Incorrect attempt can divide by zero.
    public List<String> justifiedText(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int lineStart = 0;

        while (lineStart < words.length) {
            int lineEnd = lineStart;
            int letterCount = 0;

            while (lineEnd < words.length &&
                    letterCount + words[lineEnd].length() + (lineEnd - lineStart) <= maxWidth) {
                letterCount += words[lineEnd].length();
                lineEnd++;
            }
            // build line using words from lineStart to lineEnd - 1
            if(lineEnd < words.length - 1) {
                int gaps = lineEnd - lineStart;
                int blankSpaces = (lineEnd - lineStart - 1)/gaps;
                int extraBlankSpaces = maxWidth % (lineEnd - lineStart - 1);
                    StringBuilder currLine = new StringBuilder();
                    for (int i = lineStart; i < lineEnd; i++) {
                        currLine.append(words[i]);
                        currLine.append(" ".repeat(Math.max(0, blankSpaces/(lineEnd - lineStart - 1))));
                    }
                    justifiedText.add(currLine.toString());
            }

            lineStart = lineEnd;
        }

        return justifiedText;
    }

    // Time: O(n + L * W); Auxiliary space: O(W), excluding O(L * W) output.
    // n = word count, L = output lines, W = maxWidth; includes writing padding spaces.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int lineStart = 0;

        while (lineStart < words.length) {
            int lineEnd = lineStart;
            int letterCount = 0;

            while (lineEnd < words.length &&
                    letterCount + words[lineEnd].length() + (lineEnd - lineStart) <= maxWidth) {
                letterCount += words[lineEnd].length();
                lineEnd++;
            }

            int wordCount = lineEnd - lineStart;
            int gaps = wordCount - 1;
            boolean isLastLine = lineEnd == words.length;

            StringBuilder currLine = new StringBuilder();

            if (isLastLine || wordCount == 1) {
                for (int i = lineStart; i < lineEnd; i++) {
                    currLine.append(words[i]);
                    if (i < lineEnd - 1) {
                        currLine.append(" ");
                    }
                }

                int remainingSpaces = maxWidth - currLine.length();
                currLine.append(" ".repeat(remainingSpaces));
            } else {
                int totalSpaces = maxWidth - letterCount;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = lineStart; i < lineEnd; i++) {
                    currLine.append(words[i]);

                    if (i < lineEnd - 1) {
                        int spacesToAdd = spacesPerGap;
                        if (i - lineStart < extraSpaces) {
                            spacesToAdd++;
                        }
                        currLine.append(" ".repeat(spacesToAdd));
                    }
                }
            }

            justifiedText.add(currLine.toString());
            lineStart = lineEnd;
        }

        return justifiedText;
    }

    public static void main(String[] args) {
        TextJustification sol = new TextJustification();
        String[] input = {"This", "is", "an", "example", "of", "text", "justification."};

        //initial runs

        System.out.println(sol.justifiedText(input, 16));
    }
}
