# LeetCode Top Interview 150

Java solutions and study notes for LeetCode's Top Interview 150 problem set.

## Project layout

```text
src/
|-- main/java/leetcode/
|   |-- arraystring/    # Array / String
|   |-- binarysearch/   # Binary Search
|   |-- binarytree/     # Binary Tree
|   |-- graph/          # Graph / Matrix Traversal
|   |-- hashmap/        # Hashmap
|   |-- heap/           # Heap / Priority Queue
|   |-- linkedlist/     # Linked List
|   |-- stack/          # Stack (supplemental practice)
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

| # | Problem | Difficulty | Category | Primary pattern                                        | Review |
| ---: | --- | --- | --- |--------------------------------------------------------| --- |
| 3 | [Longest Substring Without Repeating Characters](src/main/java/leetcode/slidingwindow/LongestSubstringWithoutRepeatingCharacters.java) | Medium | Sliding Window | Variable-size window with HashSet                      | |
| 6 | [Zigzag Conversion](src/main/java/leetcode/arraystring/ZigZagConversion.java) | Medium | Array / String | String simulation                                      | |
| 11 | [Container With Most Water](src/main/java/leetcode/twopointers/ContainerWithMostWater.java) | Medium | Two Pointers | Move the shorter wall                                  | |
| 12 | [Integer to Roman](src/main/java/leetcode/arraystring/IntegerToRoman.java) | Medium | Array / String | Greedy encoding                                        | |
| 13 | [Roman to Integer](src/main/java/leetcode/arraystring/RomanToInteger.java) | Easy | Array / String | String traversal                                       | |
| 15 | [3Sum](src/main/java/leetcode/twopointers/ThreeSum.java) | Medium | Two Pointers | Sorting, two pointers, handling duplicates             | |
| 19 | [Remove Nth Node From End of List](src/main/java/leetcode/linkedlist/RemoveNthNodeFromEndOfList.java) | Medium | Linked List | Two-pass counting / one-pass pointer gap with sentinel | |
| 21 | [Merge Two Sorted Lists](src/main/java/leetcode/linkedlist/MergeTwoSortedLists.java) | Easy | Linked List | Merge with a sentinel node; initial and cleaned variants | |
| 26 | [Remove Duplicates from Sorted Array](src/main/java/leetcode/arraystring/RemoveDuplicatesFromSortedArray.java) | Easy | Array / String | Two pointers                                           | |
| 33 | [Search in Rotated Sorted Array](src/main/java/leetcode/binarysearch/SearchInRotatedSortedArray.java) | Medium | Binary Search | Identify the sorted half                               | |
| 45 | [Jump Game II](src/main/java/leetcode/arraystring/JumpGameII.java) | Medium | Array / String | Greedy range expansion                                 | |
| 49 | [Group Anagrams](src/main/java/leetcode/hashmap/GroupAnagrams.java) | Medium | Hashmap | Character frequency keys                               | |
| 55 | [Jump Game](src/main/java/leetcode/arraystring/JumpGame.java) | Medium | Array / String | Greedy reachability                                    | |
| 68 | [Text Justification](src/main/java/leetcode/arraystring/TextJustification.java) | Hard | Array / String | String simulation                                      | |
| 80 | [Remove Duplicates from Sorted Array II](src/main/java/leetcode/arraystring/RemoveDuplicatesFromSortedArrayII.java) | Medium | Array / String | Two pointers                                           | |
| 88 | [Merge Sorted Array](src/main/java/leetcode/arraystring/MergeSortedArray.java) | Easy | Array / String | Two pointers from the end                              | |
| 102 | [Binary Tree Level Order Traversal](src/main/java/leetcode/binarytree/BinaryTreeLevelOrderTraversal.java) | Medium | Binary Tree | Breadth-first queue / depth-first level grouping | |
| 104 | [Maximum Depth of Binary Tree](src/main/java/leetcode/binarytree/MaximumDepthOfBinaryTree.java) | Easy | Binary Tree | Recursive depth-first traversal | |
| 121 | [Best Time to Buy and Sell Stock](src/main/java/leetcode/arraystring/BestTimeToBuyAndSellStock.java) | Easy | Array / String | Running minimum                                        | |
| 122 | [Best Time to Buy and Sell Stock II](src/main/java/leetcode/arraystring/BestTimeToBuyAndSellStockII.java) | Medium | Array / String | Greedy                                                 | |
| 134 | [Gas Station](src/main/java/leetcode/arraystring/GasStation.java) | Medium | Array / String | Greedy                                                 | |
| 135 | [Candy](src/main/java/leetcode/arraystring/Candy.java) | Hard | Array / String | Not implemented                                        | TODO |
| 141 | [Linked List Cycle](src/main/java/leetcode/linkedlist/LinkedListCycle.java) | Easy | Linked List | Fast and slow pointers | |
| 143 | [Reorder List](src/main/java/leetcode/linkedlist/ReorderList.java) | Medium | Linked List | Split, reverse, and interleave | Supplemental practice |
| 169 | [Majority Element](src/main/java/leetcode/arraystring/MajorityElement.java) | Easy | Array / String | Boyer-Moore voting                                     | |
| 189 | [Rotate Array](src/main/java/leetcode/arraystring/RotateArray.java) | Medium | Array / String | Reversal / cyclic replacement                          | |
| 206 | [Reverse Linked List](src/main/java/leetcode/linkedlist/ReverseLinkedList.java) | Easy | Linked List | Iterative pointer reversal | Supplemental practice |
| 209 | [Minimum Size Subarray Sum](src/main/java/leetcode/slidingwindow/MinimumSizeSubarraySum.java) | Medium | Sliding Window | Variable-size window                                   | |
| 215 | [Kth Largest Element in an Array](src/main/java/leetcode/heap/KthLargestElementInAnArray.java) | Medium | Heap / Selection | Max heap, bounded min heap, randomized quickselect | |
| 226 | [Invert Binary Tree](src/main/java/leetcode/binarytree/InvertBinaryTree.java) | Easy | Binary Tree | Recursive child swapping | |
| 230 | [Kth Smallest Element in a BST](src/main/java/leetcode/binarytree/KthSmallestInBST.java) | Medium | Binary Search Tree | In-order traversal | |
| 236 | [Lowest Common Ancestor of a Binary Tree](src/main/java/leetcode/binarytree/LowestCommonAncestor.java) | Medium | Binary Tree | Recursive subtree search | |
| 238 | [Product of Array Except Self](src/main/java/leetcode/arraystring/ProductOfArrayExceptSelf.java) | Medium | Array / String | Prefix and suffix products                             | |
| 242 | [Valid Anagram](src/main/java/leetcode/hashmap/ValidAnagram.java) | Easy | Hashmap | Character frequency counts                             | |
| 274 | [H-Index](src/main/java/leetcode/arraystring/HIndex.java) | Medium | Array / String | Sorting / frequency buckets                            | Latest hIndex attempt needs correction |
| 438 | [Find All Anagrams in a String](src/main/java/leetcode/slidingwindow/FindAllAnagramsInAString.java) | Medium | Sliding Window | Fixed-size window with character frequency differences | |
| 704 | [Binary Search](src/main/java/leetcode/binarysearch/BinarySearch.java) | Easy | Binary Search | Halve the search interval                              | Supplemental practice |
| 994 | [Rotting Oranges](src/main/java/leetcode/graph/RottingOranges.java) | Medium | Graph / Matrix | Multi-source breadth-first search | |
| 1046 | [Last Stone Weight](src/main/java/leetcode/heap/LastStoneWeight.java) | Easy | Heap | Max-heap simulation | Supplemental practice |

## Additional practice and review

- [3Sum practice attempt](src/main/java/leetcode/twopointers/ThreeSumPractice.java) preserves the newer attempt alongside the existing `ThreeSum` solution.
- [Daily Temperatures](src/main/java/leetcode/stack/DailyTemperatures.java) uses a monotonic stack; it is supplemental practice outside Top Interview 150.

## Shared data structures

- [TreeNode](src/main/java/leetcode/binarytree/TreeNode.java) is used by KthSmallestInBST and LowestCommonAncestor. Other tree solutions retain their own nested node classes.

- [ListNode](src/main/java/leetcode/linkedlist/ListNode.java) is shared by the linked-list solutions, including MergeTwoSortedLists and ReverseLinkedList.

## Complexity notes

Each solution variant and algorithm helper has `Time` and `Auxiliary space` comments above its method. Demo `main` methods and node constructors are excluded.

- Bounds describe the current implementation on valid problem inputs, generally in the worst case. HashMap/HashSet bounds marked **expected** assume constant-time hash operations; growable arrays/builders use amortized append costs.
- **Auxiliary space** is peak live extra storage, excluding the input and returned result. Result storage is noted separately. Temporary character arrays, debug-formatting strings, and recursion stacks count as auxiliary space.
- Symbols are defined beside each method: commonly `n` is input size, `h` tree height, `w` maximum tree width, and `k` string length or a problem parameter. A skewed tree can have `h = n`.
- Sorting note: the pointer scans in 3Sum and H-Index need O(1) space after sorting. The full methods also call `Arrays.sort(int[])`. OpenJDK 17 can merge runs using an O(n) buffer, so these comments use O(n) worst-case auxiliary space rather than assuming an always-in-place sort. See the [OpenJDK 17 sorting implementation](https://github.com/openjdk/jdk17u/blob/master/src/java.base/share/classes/java/util/DualPivotQuicksort.java). Other JDK implementations may differ.
- Stub or incorrect attempts are labeled as such. Their complexity describes the code present, not the cost of a hypothetical corrected solution. Zigzag's single-row case does not terminate, so it has no finite bound over all valid inputs.
