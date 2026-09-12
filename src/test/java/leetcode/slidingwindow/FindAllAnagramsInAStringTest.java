package leetcode.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class FindAllAnagramsInAStringTest {
    private final FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

    @Test
    void findsExamplesAndOverlappingMatches() {
        assertBoth("cbaebabacd", "abc", List.of(0, 6));
        assertBoth("abab", "ab", List.of(0, 1, 2));
        assertBoth("aaaa", "aa", List.of(0, 1, 2));
    }

    @Test
    void handlesWindowBoundariesAndRepeatedLetters() {
        assertBoth("baa", "aa", List.of(1));
        assertBoth("aab", "abb", List.of());
        assertBoth("ab", "abc", List.of());
        assertBoth("abc", "def", List.of());
        assertBoth("bca", "abc", List.of(0));
        assertBoth("a", "a", List.of(0));
        assertBoth("a", "z", List.of());
        assertBoth("zaz", "z", List.of(0, 2));
    }

    @Test
    void handlesMaximumLengthWithManyOverlappingMatches() {
        assertEquals(IntStream.rangeClosed(0, 15000).boxed().toList(),
                solution.optimizeFindAnagrams("a".repeat(30000), "a".repeat(15000)));
    }

    private void assertBoth(String s, String p, List<Integer> expected) {
        assertEquals(expected, solution.initialFindAnagrams(s, p), "Initial: " + s + ", " + p);
        assertEquals(expected, solution.optimizeFindAnagrams(s, p), "Optimized: " + s + ", " + p);
    }
}
