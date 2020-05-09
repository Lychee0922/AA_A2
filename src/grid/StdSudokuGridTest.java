package grid;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StdSudokuGridTest {

    StdSudokuGrid grid = new StdSudokuGrid();
    @org.junit.jupiter.api.Test
    void initGrid() {
        try {
            grid.initGrid("src/sampleGames/easy-std-44-01.in");
            System.out.println("==============");
            System.out.println(grid.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void outputGrid() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void validate() {
    }

    @Test
    void testDivide(){
        int[] array1 = {0,1,2,3};
        int[] array2 = {0,1,2,3,4,5,6,7,8};

        double root1 = Math.sqrt(array1.length);
        double root2 = Math.sqrt(array2.length);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i:array1){
            list1.add(i);
        }



        printList(list1);

    }

    private void printList(List<Integer> list){
        for (Integer integer:list){
            System.out.println(integer);
        }
    }
}