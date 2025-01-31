package LinkedList;

public class MatrixAddition {
    public static void main(String[] args) {
        // Predefined matrices A and B
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Get the size of the matrices
        int n = A.length;

        // Resultant matrix C
        int[][] C = new int[n][n];

        // Perform matrix addition
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Print the resultant matrix
        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("Resultant Matrix C (A + B):");
        printMatrix(C);
    }

    // Utility function to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
