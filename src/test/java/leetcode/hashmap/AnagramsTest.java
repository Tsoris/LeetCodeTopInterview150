package leetcode.hashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnagramsTest {
    @Test
    void validatesBothImplementations() {
        ValidAnagram solution = new ValidAnagram();
        String[][] inputs = {
            {"anagram", "nagaram"}, {"rat", "car"}, {"a", "aa"},
            {"aab", "abb"}, {"a", "a"}, {"ab", "ba"}
        };
        boolean[] expected = {true, false, false, false, true, true};
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], solution.isAnagram(inputs[i][0], inputs[i][1]));
            assertEquals(expected[i], solution.isAnagramAlternative(inputs[i][0], inputs[i][1]));
        }
    }

    @Test
    void groupsExampleWithBothImplementations() {
        assertGroups(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                List.of(List.of("eat", "tea", "ate"), List.of("tan", "nat"), List.of("bat")));
    }

    @Test
    void preservesDuplicatesAndEmptyStrings() {
        assertGroups(new String[]{"", "a", "", "a", "b"},
                List.of(List.of("", ""), List.of("a", "a"), List.of("b")));
    }

    @Test
    void distinguishesMultiDigitCharacterCounts() {
        String first = "a".repeat(11) + "b";
        String second = "a" + "b".repeat(11);
        String reordered = "b" + "a".repeat(11);
        assertGroups(new String[]{first, second, reordered},
                List.of(List.of(first, reordered), List.of(second)));
    }

    private void assertGroups(String[] input, List<List<String>> expected) {
        GroupAnagrams solution = new GroupAnagrams();
        assertEquals(normalize(expected), normalize(solution.initialGroupAnagrams(input)));
        assertEquals(normalize(expected), normalize(solution.optimizedGroupAnagrams(input)));
    }

    private List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sorted = new ArrayList<>(group);
            Collections.sort(sorted);
            result.add(sorted);
        }
        result.sort((left, right) -> left.toString().compareTo(right.toString()));
        return result;
    }
}
