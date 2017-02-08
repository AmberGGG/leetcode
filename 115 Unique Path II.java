public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid == null || n == 0){
            return 0;
        }
        int[][] result = new int[m][n];
        if (obstacleGrid[0][0] == 0){
            result[0][0] = 1;
        } 
        for (int i = 1; i < n; i++){
            if (obstacleGrid[0][i] == 1){
                break;
            }else {
            result[0][i] = result[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                break;
            } else {
            result[i][0] = result[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    result[i][j] = 0;
                } else {
                result[i][j] = result[i][j - 1]+ result[i - 1][j];
                }
            }
        }
        return result[m - 1][n - 1];
    }
}