package jsl.groups;

import jsl.groups.strings.JSLStringUtilsImplementation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var implement = new  JSLStringUtilsImplementation();
        System.out.println(implement.isASequenceOfSubstring("abcabc"));
    }
}