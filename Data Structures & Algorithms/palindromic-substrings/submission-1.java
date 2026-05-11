class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans += numPallin(s, i, i);
            ans += numPallin(s, i, i+1);
        }
        return ans;
    }

    int numPallin(String s, int i, int j) {
        int numPallins = 0;
        for(; i >= 0 && j < s.length(); i--, j++) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            numPallins++;
        }
        return numPallins;
    }
}