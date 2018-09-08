/**
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 */
package com.tzyl.leetcode.simplifyPath;

import java.util.Arrays;

public class Solution {
    public String simplifyPath(String path) {
        return Arrays.stream(path.split("/")).reduce("/", this::navigate);
    }

    private String navigate(String path, String segment) {
        if (segment.isEmpty() || segment.equals(".")) {
            return path;
        } else if (segment.equals("..")) {
            return getParent(path);
        } else {
            return appendSegment(path, segment);
        }
    }

    private String appendSegment(String path, String segment) {
        if (path.equals("/")) {
            return path + segment;
        }
        return path + "/" + segment;
    }

    private String getParent(String path) {
        int lastSlash = path.lastIndexOf("/");
        return lastSlash == 0 ? "/" : path.substring(0, lastSlash);
    }
}
