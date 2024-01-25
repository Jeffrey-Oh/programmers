class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];
        
        int idx = 0;
        for (int i=0; i<num_list.length; i++) {
            int num = num_list[i];
            
            if (i + 1 >= n) {
                answer[idx++] = num;
            }
        }
        
        return answer;
    }
}