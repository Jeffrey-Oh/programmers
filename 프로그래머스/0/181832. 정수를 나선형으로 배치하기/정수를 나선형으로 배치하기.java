class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int direction = 0; // 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3 : 위쪽
        
        // (0, 0), (0, 1), (0, 2), (0, 3)
        // (1, 0),                 (1, 3)
        // (2, 0),                 (2, 3)
        // (3, 0), (3, 1), (3, 2), (3, 3)
        
        int x = 0;
        int y = 0;
        
        for (int i=0; i<n*n; i++) {
            if (i == 0) {
                answer[0][0] = i + 1;
                continue;
            }

            if (direction == 0) {
                if (y + 1 < n && answer[x][y + 1] == 0)
                    answer[x][++y] = i + 1;
                else {
                    direction = changeDirection(direction);
                    answer[++x][y] = i + 1;
                }
            } else if (direction == 1) {
                if (x + 1 < n && answer[x + 1][y] == 0)
                    answer[++x][y] = i + 1;
                else {
                    direction = changeDirection(direction);
                    answer[x][--y] = i + 1;
                }
            } else if (direction == 2) {
                if (y - 1 >= 0 && answer[x][y - 1] == 0)
                    answer[x][--y] = i + 1;
                else {
                    direction = changeDirection(direction);
                    answer[--x][y] = i + 1;
                }
            } else {
                if (x - 1 >= 0 && answer[x - 1][y] == 0)
                    answer[--x][y] = i + 1;
                else {
                    direction = changeDirection(direction);
                    answer[x][++y] = i + 1;
                }
            }
        }
        
        return answer;
    }
    
    public static int changeDirection(int direction) {
        int result = direction;
        
        switch(direction) {
            case 0:
                result = 1;
                break;
            case 1:
                result = 2;
                break;
            case 2:
                result = 3;
                break;
            default:
                result = 0;
                break;
        }
        
        return result;
    }
}