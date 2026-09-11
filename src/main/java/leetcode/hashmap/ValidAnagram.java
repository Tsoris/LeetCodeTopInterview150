package leetcode.hashmap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charFrequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i ++) {
            int checkChar = t.charAt(i) - 'a';

            if (charFrequency[checkChar] <= 0) {
                return false;
            }

            charFrequency[checkChar] --;
        }

        return true;
    }

    public boolean isAnagramAlternative(String s, String t) {
        //Interesting, slightly out of the boxing solution; slightly deeper reasoning
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        // O(1) Char balance check; trivial time complexity
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args){
        ValidAnagram sol = new ValidAnagram();

        System.out.println(sol.isAnagram("anagram", "nagaram"));

        System.out.println(sol.isAnagram("rat", "car"));
    }
}
