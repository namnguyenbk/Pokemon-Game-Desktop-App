package algorithms;

import java.util.Scanner;

public class Matching {
    private static final boolean checkLineX(int[][] map, int y1, int y2, int x) {
        int min = Math.min(y1, y2);
        int max = Math.max(y1, y2);
        for (int y = min + 1; y < max; y++){
            if(map[x][y] != 0){
                return false;
            }
        }
        return true;
    }
    private static final boolean checkLineY(int[][]map, int x1, int x2, int y) {
        int min = Math.min(x1, x2);
        int max = Math.max(x1, x2);
        for (int x = min + 1; x < max; x++){
            if(map[x][y] != 0){
                return false;
            }
        }
        return true;
    }

    private static final int checkRectX(int[][] map, int x1, int y1, int x2, int y2){
        if (x1== x2) return -1;
        int[] yMinPoint;
        int[] yMaxPoint;
        if (y1 > y2) {
            yMaxPoint = new int[]{x1, y1};
            yMinPoint = new int[]{x2,y2};
        } else {
            yMaxPoint = new int[]{x2, y2};
            yMinPoint = new int[]{x1,y1};
        }
        int y = yMinPoint[1];
        if (checkLineX(map, y, yMinPoint[1], yMinPoint[0])
                && map[yMaxPoint[0]][y] == 0
                && checkLineY(map, yMinPoint[0], yMaxPoint[0], y)
                && checkLineX(map, yMaxPoint[1], y, yMaxPoint[0]))
            return y;
        y++;
        for (; y < yMaxPoint[1]; y++){
            if (map[x1][y]==0 && map[x2][y]==0 && checkLineX(map, yMinPoint[1], y, yMinPoint[0])
                    && checkLineY(map, yMinPoint[0], yMaxPoint[0], y)
                    && checkLineX(map, yMaxPoint[1], y, yMaxPoint[0]))
                return y;
        }
        if (checkLineX(map, y, yMinPoint[1], yMinPoint[0])
                && map[yMinPoint[0]][y] == 0
                && checkLineY(map, yMinPoint[0], yMaxPoint[0], y)
                && checkLineX(map, yMaxPoint[1], y, yMaxPoint[0]))
            return y;
        return -1;
    }
    private static final int checkRectY(int[][] map, int x1, int y1, int x2, int y2){
        if(y1==y2) return -1;
        int[] xMinPoint;
        int[] xMaxPoint;
        if (x1 > x2) {
            xMaxPoint = new int[]{x1, y1};
            xMinPoint = new int[]{x2,y2};
        } else {
            xMaxPoint = new int[]{x2, y2};
            xMinPoint = new int[]{x1,y1};
        }
        int x = xMinPoint[0];
        if (checkLineY(map, xMinPoint[0], x, xMinPoint[1])
                && map[x][xMaxPoint[1]] == 0
                && checkLineX(map, xMaxPoint[1], xMinPoint[1], x)
                && checkLineY(map, xMaxPoint[0], x, xMaxPoint[1]))
            return x;
        x++;
        for (; x < xMaxPoint[0]; x++){
            if (map[x][y1]==0 && map[x][y2]==0&&checkLineY(map, xMinPoint[0], x, xMinPoint[1])
                    && checkLineX(map, xMaxPoint[1], xMinPoint[1], x)
                    && checkLineY(map, xMaxPoint[0], x, xMaxPoint[1]))
                return x;
        }
        if (checkLineY(map, xMinPoint[0], x, xMinPoint[1])
                && map[x][xMinPoint[1]] == 0
                && checkLineX(map, xMaxPoint[1], xMinPoint[1], x)
                && checkLineY(map, xMaxPoint[0], x, xMaxPoint[1]))
            return x;
        return -1;
    }
    private static final int checkMoreLineX(int[][] map, int x1, int y1, int x2, int y2, int step){
        int[] yMinPoint;
        int[] yMaxPoint;
        if (y1 > y2) {
            yMaxPoint = new int[]{x1, y1};
            yMinPoint = new int[]{x2,y2};
        } else {
            yMaxPoint = new int[]{x2, y2};
            yMinPoint = new int[]{x1,y1};
        }
        int y = yMaxPoint[1];
        int row = yMinPoint[0];
        if (step == -1){
            y = yMinPoint[1];
            row = yMaxPoint[0];
        }
        if (map[row][y] == 0 && checkLineX(map,yMaxPoint[1],yMinPoint[1],row)){
            y += step;
            while (map[yMinPoint[0]][y] == 0 && map[yMaxPoint[0]][y] == 0){
                if (checkLineY(map, yMaxPoint[0], yMinPoint[0], y)){
                    return y;
                }
                y += step;
            }
        }
        return -1;
    }
    private static final int checkMoreLineY(int[][] map, int x1, int y1, int x2, int y2, int step){
        int[] xMinPoint;
        int[] xMaxPoint;
        if (x1 > x2) {
            xMaxPoint = new int[]{x1, y1};
            xMinPoint = new int[]{x2,y2};
        } else {
            xMaxPoint = new int[]{x2, y2};
            xMinPoint = new int[]{x1,y1};
        }
        int x = xMaxPoint[0];
        int col = xMinPoint[1];
        if (step == -1){
            x = xMinPoint[0];
            col = xMaxPoint[1];
        }
        if (map[x][col] == 0 && checkLineX(map,xMaxPoint[0],xMinPoint[0],col)){
            x += step;
            while (map[x][xMaxPoint[1]] == 0 && map[x][xMinPoint[1]] == 0){
                if (checkLineX(map, xMaxPoint[1], xMinPoint[1], x)){
                    return x;
                }
                x += step;
            }
        }
        return -1;
    }


    // Y tuong: ket qua tra ve la toa do cua 2 diem tu do ve nen mot duong thang ma 2 diem da kiem tra se noi vuong goc vao duong thang do
    public static final int[][] checkTwoPoint(int[][] map, int x1, int y1, int x2, int y2) {
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
