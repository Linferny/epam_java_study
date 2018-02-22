package javase01.t05.logic;

public class Logic {
    public void drawRectMatrix(int n) {

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n / 2; i++) {
            matrix[i][i] = 1;
            matrix[n - i - 1][n - i - 1] = 1;
            matrix[n - i - 1][i] = 1;
            matrix[i][n - i - 1] = 1;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                str.append(String.format("%d ", matrix[j][i]));
            }
            str.deleteCharAt(str.length() - 1);
            str.append('\n');
        }
        System.out.println(str);
    }
}
