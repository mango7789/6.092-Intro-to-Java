package A7;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathName));
            List<int[]> matrix = new ArrayList<>();
            int numRows = 0;
            int numCols = -1;

            // For each line in the file ...
            String line;
            while ((line = reader.readLine()) != null) {
                // ... sum each row of numbers
                String[] parts = line.split("\t");

                // Skip the empty row
                if (Objects.equals(parts[0], "")) {
                    continue;
                }

                // Save the numbers in txt file to a matrix
                int[] row = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    row[i] = Integer.parseInt(parts[i]);
                }

                // Update the number of rows and cols
                numRows++;
                if (numCols == -1) { numCols = parts.length; }
                matrix.add(row);
            }

            // Check if the matrix is square
            if (numRows != numCols) return false;

            int LineSum = -1;
            // Check rowSum
            for (int[] row : matrix) {
                int CurrSum = 0;
                for (int entry : row) {
                    CurrSum += entry;
                }
                if (LineSum == -1) LineSum = CurrSum;
                if (CurrSum != LineSum) return false;
            }

            // Check colSum
            for (int col = 0; col < numCols; col++) {
                int CurrSum = 0;
                for (int[] row : matrix) {
                    CurrSum += row[col];
                }
                if (CurrSum != LineSum) return false;
            }

            // Check the sum of diagonal entries
            int MainSum = 0, AntiSum = 0;
            for (int i = 0; i < numRows; i++) {
                MainSum += matrix.get(i)[i];
                AntiSum += matrix.get(i)[numRows - 1 - i];
            }
            if (MainSum != LineSum || AntiSum != LineSum) return false;

            reader.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}
