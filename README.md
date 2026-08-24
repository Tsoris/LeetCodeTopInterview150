# LeetCode Top Interview 150

Java solutions and study notes for LeetCode's Top Interview 150 problem set.

## Project layout

```text
src/
|-- main/java/leetcode/
|   |-- arraystring/    # Array / String
|   |-- slidingwindow/  # Sliding Window
|   `-- twopointers/    # Two Pointers
`-- test/java/leetcode/ # JUnit tests, mirroring the main package tree
```

## Run the tests

This project uses Java 17 and JUnit 5 through Maven:

```bash
mvn test
```

## Solution index

| # | Problem | Difficulty | Category | Primary pattern | Review |
| ---: | --- | --- | --- | --- | --- |
| 6 | [Zigzag Conversion](src/main/java/leetcode/arraystring/ZigZagConversion.java) | Medium | Array / String | String simulation | |
| 12 | [Integer to Roman](src/main/java/leetcode/arraystring/IntegerToRoman.java) | Medium | Array / String | Greedy encoding | |
| 13 | [Roman to Integer](src/main/java/leetcode/arraystring/RomanToInteger.java) | Easy | Array / String | String traversal | |
| 15 | [3Sum](src/main/java/leetcode/twopointers/ThreeSum.java) | Medium | Two Pointers | Sorting and two pointers | |
| 26 | [Remove Duplicates from Sorted Array](src/main/java/leetcode/arraystring/RemoveDuplicatesFromSortedArray.java) | Easy | Array / String | Two pointers | |
| 45 | [Jump Game II](src/main/java/leetcode/arraystring/JumpGameII.java) | Medium | Array / String | Greedy range expansion | |
| 55 | [Jump Game](src/main/java/leetcode/arraystring/JumpGame.java) | Medium | Array / String | Greedy reachability | |
| 68 | [Text Justification](src/main/java/leetcode/arraystring/TextJustification.java) | Hard | Array / String | String simulation | |
| 80 | [Remove Duplicates from Sorted Array II](src/main/java/leetcode/arraystring/RemoveDuplicatesFromSortedArrayII.java) | Medium | Array / String | Two pointers | |
| 88 | [Merge Sorted Array](src/main/java/leetcode/arraystring/MergeSortedArray.java) | Easy | Array / String | Two pointers from the end | |
| 121 | [Best Time to Buy and Sell Stock](src/main/java/leetcode/arraystring/BestTimeToBuyAndSellStock.java) | Easy | Array / String | Running minimum | |
| 122 | [Best Time to Buy and Sell Stock II](src/main/java/leetcode/arraystring/BestTimeToBuyAndSellStockII.java) | Medium | Array / String | Greedy | |
| 134 | [Gas Station](src/main/java/leetcode/arraystring/GasStation.java) | Medium | Array / String | Greedy | |
| 169 | [Majority Element](src/main/java/leetcode/arraystring/MajorityElement.java) | Easy | Array / String | Boyer-Moore voting | |
| 189 | [Rotate Array](src/main/java/leetcode/arraystring/RotateArray.java) | Medium | Array / String | Reversal / cyclic replacement | |
| 209 | [Minimum Size Subarray Sum](src/main/java/leetcode/slidingwindow/MinimumSizeSubarraySum.java) | Medium | Sliding Window | Variable-size window | |
| 238 | [Product of Array Except Self](src/main/java/leetcode/arraystring/ProductOfArrayExceptSelf.java) | Medium | Array / String | Prefix and suffix products | |
| 274 | [H-Index](src/main/java/leetcode/arraystring/HIndex.java) | Medium | Array / String | Sorting | |
