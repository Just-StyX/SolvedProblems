package jsl.groups.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Permutation.
 *
 * @author github.com/Just-StyX
 */
public class Permutation {
    /**
     * Permutation list.
     *
     * @param string the string
     * @return the list of all permutation
     */
    public List<String> permutation(String string) {
        List<String> perm = new ArrayList<>();
        return permutation(string, "");
    }

    /**
     * Permutation helper function.
     *
     * @param string the string
     * @param prefix the prefix
     * @return the list
     */
    public List<String> permutation(String string, String prefix) {
        List<String> perm = new ArrayList<>();
        var lengthOfString = string.length();

        if (lengthOfString == 0) {
            perm.add(prefix);
            return perm;
        }
        else {
            for (int start = 0; start < lengthOfString; start++) {
                perm.addAll(permutation(
                        string.substring(start + 1, lengthOfString) + string.substring(0, start),
                        prefix + string.charAt(start)));
            }
        }
        return perm;
    }

    /**
     * Factorial long.
     *
     * @param n the n
     * @return the long
     */
    public long factorial(long n) {
        return factorial(n, 1);
    }

    /**
     * Factorial helper function.
     *
     * @param n      the n
     * @param result the result
     * @return the long
     */
    public long factorial(long n, long result) {
        if (n == 1 || n == 0) return result;
        else return factorial(n - 1, result * n);
    }
}
