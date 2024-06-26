package jsl.groups.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The type Compare versions.
 * @author github.com/Just-StyX
 */
public class CompareVersions implements Comparator<String> {

    @Override
    public int compare(String versionOne, String versionTwo) {
        int result = 0;
        var versionOneList = Arrays.stream(versionOne.split("\\.")).map(Integer::valueOf).toList();
        var versionTwoList = Arrays.stream(versionTwo.split("\\.")).map(Integer::valueOf).toList();

        int position = 0;
        while (position < versionOneList.size() && position < versionTwoList.size() && result == 0) {
            result = versionOneList.get(position).compareTo(versionTwoList.get(position));
            position++;
        }

        if (result == 0) return Integer.compare(versionOneList.size(), versionTwoList.size());
        return result;
    }
}
