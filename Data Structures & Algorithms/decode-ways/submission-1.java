class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings_(s, 0, memo);
    }

    int numDecodings_(String s, int i, int[] memo) {
        if(i < s.length() && s.charAt(i) == '0') {
            return memo[i] = 0;
        }
        if(i == s.length()) {
            return 1;
        }
        if(memo[i] != -1) {
            return memo[i];
        }

        int ans = numDecodings_(s, i + 1, memo);
        if(i < s.length() - 1){
            int num = Integer.parseInt("" + s.charAt(i) + s.charAt(i+1));
            if(num > 9 && num <=26) { 
                ans += numDecodings_(s, i + 2, memo);
            }            
        }
        return memo[i] = ans;
    }
}
