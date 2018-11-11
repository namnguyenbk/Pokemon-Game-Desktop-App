package algorithms;

import java.util.Scanner;

public class Matching {
    public static int[][] maxX(int x1, int y1, int x2, int y2) {
        return x1 > x2 ? new int[][]{{x1,y1},{x2,y2}} : new int[][]{{x2,y2},{x1,y1}};
    }
    public static int[][] maxY(int x1, int y1, int x2, int y2) {
        return y1 > y2 ? new int[][]{{x1,y1},{x2,y2}} : new int[][]{{x2,y2},{x1,y1}};
    }
    public static final boolean checkLineX(int[][] map, int y1, int y2, int x) {
        int[][] maxCol = maxY(x,y1,x,y2);
        int min = maxCol[1][1];
        int max = maxCol[0][1];
        for (int y = min + 1; y < max; y++){
            if(map[x][y] != 0){
                return false;
            }
        }
        return true;
    }
    public static final boolean checkLineY(int[][]map, int x1, int x2, int y) {
        int[][] minRow = maxX(x1,y,x2,y);
        int min = minRow[1][0];
        int max = minRow[0][0];
        for (int x = min + 1; x < max; x++){
            if(map[x][y] != 0){
                return false;
            }
        }
        return true;
    }

    public static final int checkRectX(int[][] map, int x1, int y1, int x2, int y2){
        int[][] maxCol = maxY(x1,y1,x2,y2);
        int[] yMinPoint = maxCol[1];
        int[] yMaxPoint = maxCol[0];
        for (int y = yMinPoint[1] + 1; y < yMaxPoint[1]; y++){
            if (map[x1][y]==0 && map[x2][y]==0){ // 3 duong thang tao thanh chu Z duoc tao tu 4 diem: hai diem can kiem tra va 2 diem bang 0
                if (checkLineX(map, yMinPoint[1], y, yMinPoint[0]) // duong thang noi tu 1 diem den 1 diem bang 0
                        && checkLineY(map, yMinPoint[0], yMaxPoint[0], y) // duong thang noi hai diem bang 0
                        && checkLineX(map, yMaxPoint[1], y, yMaxPoint[0])) // duong thang noi diem con lai va diem bang 0 con lai
                    return y;
            }

        }
        return -1;
    }
    public static final int checkRectY(int[][] map, int x1, int y1, int x2, int y2){
        int[][] maxRow = maxX(x1,y1,x2,y2);
        int[] xMinPoint = maxRow[1];
        int[] xMaxPoint = maxRow[0];
        for (int x = xMinPoint[0] + 1; x < xMaxPoint[0]; x++){
            if (map[x][y1]==0 && map[x][y2]==0){
                if (checkLineY(map, xMinPoint[0], x, xMinPoint[1])
                        && checkLineX(map, xMaxPoint[1], xMinPoint[1], x)
                        && checkLineY(map, xMaxPoint[0], x, xMaxPoint[1]))
                return x;
            }

        }
        return -1;
    }
     public static int checkMoreLineX(int[][] map, int x1, int y1, int x2, int y2, int step){
         int[][] maxCol = maxY(x1,y1,x2,y2);
         int[] yMinPoint = maxCol[1];
         int[] yMaxPoint = maxCol[0];
        int y = yMaxPoint[1];
        int row = yMinPoint[0];
        if (step == -1){
            y = yMinPoint[1];
            row = yMaxPoint[0];
        }
        if (map[row][y] == 0 || y1 == y2) {
            if (checkLineX(map, yMaxPoint[1], yMinPoint[1], row)) {
                do {
                    if (checkLineY(map, yMaxPoint[0], yMinPoint[0], y)) {
                        return y;
                    }
                    y += step;
                } while (map[yMinPoint[0]][y] == 0 && map[yMaxPoint[0]][y] == 0);
            }
        }
        return -1;
    }
    public static final int checkMoreLineY(int[][] map, int x1, int y1, int x2, int y2, int step){
        int[][] maxRow = maxX(x1,y1,x2,y2);
        int[] xMinPoint = maxRow[1];
        int[] xMaxPoint = maxRow[0];
        int x = xMaxPoint[0];
        int col = xMinPoint[1];
        if (step == -1){
            x = xMinPoint[0];
            col = xMaxPoint[1];
        }
<<<<<<< HEAD
        if (map[x][col] == 0 || x1 == x2) { // map[x][col] == 0 thi co kha nang vao truong hop chu L hoac x1 == x2 se la TH chu U
            if (checkLineY(map, xMaxPoint[0], xMinPoint[0], col)) {
                do {
                    if (checkLineX(map, xMaxPoint[1], xMinPoint[1], x)) {
                        return x;
                    }
                    x += step;
                } while (map[x][xMaxPoint[1]] == 0 && map[x][xMinPoint[1]] == 0);
=======
        if ((map[x][col] == 0 || x1==x2) && checkLineY(map,xMaxPoint[0],xMinPoint[0],col)){
            x += step;
            while (map[x][xMaxPoint[1]] == 0 && map[x][xMinPoint[1]] == 0){
                if (checkLineX(map, xMaxPoint[1], xMinPoint[1], x)){
                    return x;
                }
                x += step;
>>>>>>> 1b3aad3bf11f05565a04237174fa315438578a20
            }
        }
        return -1;
    }


    // Y tuong: ket qua tra ve la toa do cua 2 diem tu do ve nen mot duong thang ma 2 diem da kiem tra se noi vuong goc vao duong thang do
    public static final int[][] checkTwoPoint(int[][] map, int x1, int y1, int x2, int y2) {
//        System.out.println("X1: " + x1 );
//        System.out.println("Y1: " + y1 );
//        System.out.println(map[x1][y1]);
//        System.out.println("X2: " + x2 );
//        System.out.println("Y2: " + y2 );
//        System.out.println(map[x2][y2]);
        if (map[x1][y1] != map[x2][y2]) return new int[][]{};
        if (x1==x2 && y1==y2) return new int[][]{};
        if (x1 == x2) {
            if(checkLineX(map,y1, y2, x1))
                return new int[][]{{x1,y1},{x2,y2}};
        }
        if (y1 == y2) {
            if (checkLineY(map,x1, x2, y1))
                return new int[][]{{x1,y1},{x2,y2}};
        }
        int t;
        if((t = checkRectX(map, x1, y1, x2,y2)) != -1){
            return new int[][]{{x1,t},{x2,t}};
        }
        if((t = checkRectY(map, x1, y1, x2,y2)) != -1){
            return new int[][]{{t,y1},{t,y2}};
        }
        if ((t = checkMoreLineX(map, x1, y1, x2,y2,1)) != -1) {
            return new int[][]{{x1,t},{x2,t}};
        }

        if ((t = checkMoreLineX(map, x1, y1, x2,y2,-1)) != -1) {
            return new int[][]{{x1,t},{x2,t}};
        }

        if ((t = checkMoreLineY(map, x1, y1, x2,y2,1)) != -1) {
            return new int[][]{{t,y1},{t,y2}};
        }

        if ((t = checkMoreLineY(map, x1, y1, x2,y2,-1)) != -1) {
            return new int[][]{{t,y1},{t,y2}};
        }
        return new int[][]{};
    }

    public static void main(String[] args) {
        int[][] map = Shuffle.initMapdefault();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 18 ; j++) {
                System.out.printf("%3d",map[i][j]);
            }
            System.out.println("\n");
        }
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Nhap toa do:");

            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int[][] route = checkTwoPoint(map, x1, y1, x2, y2);
            if (route.length == 0) System.out.println("No move!");
            else {
                System.out.println(route[0][0]);
                System.out.println(route[0][1]);
                System.out.println(route[1][0]);
                System.out.println(route[1][1]);
            }
        }
    }
}
