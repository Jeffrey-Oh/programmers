class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        
        for (int i=0; i<num_list.length; i++) {
            if (i < n) {
                answer[i] = num_list[i];
                continue;
            }
            
            break;
        }
        
        return answer;
    }
}