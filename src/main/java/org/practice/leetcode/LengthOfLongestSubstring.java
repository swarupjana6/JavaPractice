package org.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

//3. Longest Substring Without Repeating Characters
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 ){
            return 0;
        }
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        List<String> storeChar = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            StringBuilder words = new StringBuilder();
            for(int j = i; j < s.length(); j++){
                if(words.toString().indexOf(chars[j]) >= 0){
                    if(storeChar.isEmpty() || storeChar.get(0).length() < words.length()){
                        storeChar.clear();
                        storeChar.add(words.toString());
                    }
                    break;
                } else {
                    words.append(chars[j]);
                    if((i == s.length() - 1 || j == s.length() - 1)){
                        if(storeChar.isEmpty() || storeChar.get(0).length() < words.length()) {
                            storeChar.clear();
                            storeChar.add(words.toString());
                        }
                    }
                }
            }
        }

        return storeChar.get(0).length();

    }

    public static void main(String[] args) {

        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println("Input: s = \"abcabcbb\"");
        System.out.println("Output : " + lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println();

        System.out.println("Input: s = \"bbbbb\"");
        System.out.println("Output : " + lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println();

        System.out.println("Input: s = \"pwwkew\"");
        System.out.println("Output : " + lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println();

        System.out.println("Input: s = \" \"");
        System.out.println("Output : " + lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
        System.out.println();

        System.out.println("Input: s = \"aab\"");
        System.out.println("Output : " + lengthOfLongestSubstring.lengthOfLongestSubstring("aab"));
        System.out.println();
     }
}
