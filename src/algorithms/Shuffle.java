package algorithms;

import java.util.Random;

public class Shuffle {
    private static  int[][] mapDefault = new int[9][16];
    public static void initMapdefault(){
        int id = 1;
//        for (int i = 0; i < 9 ; i++) {
//            for (int j = 0; j < 16; j+= 2) {
//                for (int k = 0; k < 2 ; k++) {
//                    if (id > 36) id =1;
//                    mapDefault[i][j+k] = id;
//                }
//                id++;
//            }
//        }
        mapDefault[0] = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 1, 5, 10,14,19,23,28,32};
        mapDefault[1] = new int[]{5, 5, 6, 6, 7, 7, 8, 8, 1, 6, 10,15,29,24,28,33};
        mapDefault[2] = new int[]{9, 9,10,10,11,11,12,12, 2, 6,11,15,20,24,29,33};
        mapDefault[3] = new int[]{13,13,14,14,15,15,16,16, 2, 7,11,16,20,25,29,34};
        mapDefault[4] = new int[]{17,17,18,18,19,19,20,20, 3, 7,12,16,21,25,30,34};
        mapDefault[5] = new int[]{21,21,22,22,23,23,24,24, 3, 8,12,17,21,26,30,35};
        mapDefault[6] = new int[]{25,25,26,26,27,27,28,28, 4, 8,13,17,22,26,31,35};
        mapDefault[7] = new int[]{29,29,30,30,31,31,32,32, 4, 9,13,18,22,27,31,36};
        mapDefault[8] = new int[]{33,33,34,34,35,35,36,36, 5, 9,14,18,23,27,32,36};
    }

    public static int[][] shuffleMapDefault( int[][] map){
        Random rand = new Random();
        int  row;
        int  col;
        int lengthRow = map[0].length;
        int lengthCol = map.length;
        for (int i = 0; i < 30 ; i++) {
            row = rand.nextInt(8) + 0;
            reverseRow(map, row, lengthRow );
            col = rand.nextInt(15) + 0;
            reverseCol(map, col, lengthCol );
        }

        return map;
    }

    private static int[][] reverseRow( int[][] map, int row, int rowLenght){
        for (int i = 0; i < rowLenght/ 2 ; i++) {
            swap(map, row, i, row, rowLenght -i -1);
        }
        return map;
    }
    private static int[][] reverseCol( int[][] map, int col, int colLenght){
        for (int i = 0; i < colLenght/ 2 ; i++) {
            swap(map, i, col, colLenght-i-1, col);
        }
        return map;
    }
    private static int[][] swap( int[][] listItem,int row1, int col1, int row2, int col2 ){
        int temp = listItem[row1][col1];
        listItem[row1][col1] = listItem[row2][col2];
        listItem[row2][col2] = temp;
        return listItem;
    }
    public static void main(String[] args) {
        initMapdefault();
        mapDefault = shuffleMapDefault(mapDefault);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 16 ; j++) {
                System.out.printf("%3d",mapDefault[i][j]);
            }
            System.out.println("\n");
        }
    }
}
