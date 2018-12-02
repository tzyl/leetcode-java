/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
package com.tzyl.leetcode.wordSearch;

import java.util.*;

public class Solution {
    private static final List<Pair<Integer>> deltas = Arrays.asList(
            Pair.of(-1, 0),
            Pair.of(0, 1),
            Pair.of(1, 0),
            Pair.of(0, -1)
    );


    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j) {
        return search(Pair.of(i, j), 0, new HashSet<>());
    }

    private boolean search(Pair<Integer> current, int targetIndex, Set<Pair<Integer>> visited) {
        int i = current.getLeft();
        int j = current.getRight();
        if (targetIndex == word.length()) {
            return true;
        } else if (!isValid(current)) {
            return false;
        } else if (board[i][j] != word.charAt(targetIndex)) {
            return false;
        }
        boolean found = false;
        visited.add(current);
        for (Pair<Integer> delta : deltas) {
            int s = i + delta.getLeft();
            int t = j + delta.getRight();
            Pair<Integer> neighbour = Pair.of(s, t);
            if (!visited.contains(neighbour) && search(neighbour, targetIndex + 1, visited)) {
                found = true;
                break;
            }
        }
        visited.remove(current);
        return found;
    }

    private boolean isValid(Pair<Integer> pair) {
        int m = board.length;
        int n = board[0].length;
        int i = pair.getLeft();
        int j = pair.getRight();
        return 0 <= i && i < m && 0 <= j && j < n;
    }

    private static class Pair<T> {
        private T left;
        private T right;

        public Pair(T left, T right) {
            this.left = left;
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public T getRight() {
            return right;
        }

        public static <T> Pair<T> of(T left, T right) {
            return new Pair<>(left, right);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?> pair = (Pair<?>) o;
            return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
