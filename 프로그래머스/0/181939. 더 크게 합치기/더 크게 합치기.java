class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String numA = String.valueOf(a);
        String numB = String.valueOf(b);
        
        int mergeA = Integer.parseInt(numA + numB);
        int mergeB = Integer.parseInt(numB + numA);
        
        return mergeA == mergeB ? mergeA : mergeA > mergeB ? mergeA : mergeB;
    }
}