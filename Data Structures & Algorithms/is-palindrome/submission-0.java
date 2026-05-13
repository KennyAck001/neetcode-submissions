class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        return palindrome(str.replaceAll("[^a-zA-z0-9]",""));
    }
    public boolean palindrome(String s){
        if(s.length() < 0) return false;

        int first = 0;
        int last = s.length()-1;

        while(first < last){
            char firstChar = s.charAt(first);
            char lastChar = s.charAt(last);

            if(firstChar != lastChar) return false;
            first++;
            last--;
        }
        return true;
    }
}
