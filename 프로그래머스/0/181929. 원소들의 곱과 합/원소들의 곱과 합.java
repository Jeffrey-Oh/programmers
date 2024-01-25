class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int multiply = 1;
        int sum = 0;
        
        for (int i=0; i<num_list.length; i++) {
            int num = num_list[i];
            multiply *= num;
            sum += num;
        }
        
        return multiply < sum*sum ? 1 : 0;
    }
}