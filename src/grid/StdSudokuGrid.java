/**
 * @author Jeffrey Chan & Minyi Li, RMIT 2020
 */
package grid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class implementing the grid for standard Sudoku.
 * Extends SudokuGrid (hence implements all abstract methods in that abstract
 * class).
 * You will need to complete the implementation for this for task A and
 * subsequently use it to complete the other classes.
 * See the comments in SudokuGrid to understand what each overriden method is
 * aiming to do (and hence what you should aim for in your implementation).
 */
public class StdSudokuGrid extends SudokuGrid {
    // TODO: Add your own attributes
    int[][] matrix;
    int[] numbers;

    public StdSudokuGrid() {
        super();

        // TODO: any necessary initialisation at the constructor
    } // end of StdSudokuGrid()


    /* ********************************************************* */


    @Override
    public void initGrid(String filename)
            throws FileNotFoundException, IOException {
        // TODO
        List<String> list = new ArrayList<>();
        File file = new File(filename);
        BufferedReader br = new BufferedReader(
                new FileReader(file));
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        int size = Integer.parseInt(list.get(0));
        matrix = new int[size][size];
        if (!validate()) {
            throw new IOException();
        }
        String[] nums = list.get(1).split(" ");
        numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 2; i < list.size(); i++) {
            String[] hint = list.get(i).split(" ");
            String[] coordinate = hint[0].split(",");


            int row = Integer.parseInt(coordinate[0]);
            int col = Integer.parseInt(coordinate[1]);
            int fill = Integer.parseInt(hint[1]);

            matrix[row][col] = fill;

        }

        printMatrix();
    } // end of initBoard()

    private void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private void printMatrix() {
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void outputGrid(String filename)
            throws FileNotFoundException, IOException {
        // TODO
    } // end of outputBoard()


    @Override
    public String toString() {
        // TODO
        StringBuilder sb = new StringBuilder();
        String line = "";
        for (int[] ints : matrix) {
            for (int i : ints) {
                line += i + " ";
            }
            line = line.substring(0, line.length() - 1);
            line += "\r\n";
            sb.append(line);
            line = "";
        }
        // placeholder
        return sb.toString();
    } // end of toString()


    @Override
    public boolean validate() {
        // TODO
        double rows = matrix.length;
        double cols = matrix[0].length;
        double root = Math.sqrt(rows);
        boolean condition1 = (rows == cols && root == Math.floor(root));

        List<Integer> tries;
        boolean condition2 = true;
        for (int i = 0; i < rows; i++) {
            tries = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                int value = matrix[i][j];
                if (value != 0) {
                    if (hasNum(numbers, value) &&
                            !tries.contains(new Integer(value))) {
                        tries.add(new Integer(value));
                    } else {
                        condition2 = false;
                    }
                }
                tries = new ArrayList<>();
            }
        }

        boolean condition3 = true;
        for (int i = 0; i<cols;i++){
            tries = new ArrayList<>();
            for (int j = 0;j<rows;j++){
                int value = matrix[i][j];
                if (value != 0) {
                    if (hasNum(numbers, value) &&
                            !tries.contains(new Integer(value))) {
                        tries.add(new Integer(value));
                    } else {
                        condition3 = false;
                    }
                }
                tries = new ArrayList<>();
            }
        }



        // placeholder
        return condition1 && condition2 && condition3;
    } // end of validate()


    private boolean hasNum(int[] ints, int n) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == n) {
                return true;
            }
        }
        return false;
    }
} // end of class StdSudokuGrid
