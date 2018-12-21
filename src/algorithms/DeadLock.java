package algorithms;
import java.util.ArrayList;

public class DeadLock {
    public static class pokemon{
        public int id;
        public int rowIndex;
        public int colIndex;
        public pokemon(int id, int rowIndex, int colIndex){
            this.id = id;
            this.colIndex = colIndex;
            this.rowIndex = rowIndex;
        }
    }

    private static ArrayList<ArrayList<pokemon>> listPokemon;

    public static ArrayList<ArrayList<pokemon>> initStatusMap(int[][] map ){
        ArrayList<ArrayList<pokemon>> listPokemon = new ArrayList<ArrayList<pokemon>>(36);
        for(int i = 0 ; i < 37; i++){
            listPokemon.add(new ArrayList<pokemon>());
        }
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0 ; j < map[i].length; j++){
                if(map[i][j] > 0){
                    listPokemon.get(map[i][j]).add(new pokemon(map[i][j],i,j));
                }
            }
        }
        return listPokemon;
    }

    public static ArrayList<ArrayList<pokemon>> updateStatusMap(ArrayList<ArrayList<pokemon>> listPokemon,int id, int x1, int y1, int x2, int y2){
//        pokemon p1 = new pokemon(id, x1, y1);
//        pokemon p2 = new pokemon(id, x2, y2);
//        listPokemon.get(id).remove(p1);
//        listPokemon.get(id).remove(p2);
        for(int i = 0; i < listPokemon.get(id).size(); i++){
            if((listPokemon.get(id).get(i).rowIndex == x1 && listPokemon.get(id).get(i).colIndex == y1)||(listPokemon.get(id).get(i).rowIndex == x2 && listPokemon.get(id).get(i).colIndex == y2)){
                listPokemon.get(id).remove(listPokemon.get(id).get(i));
                i--;
            }
        }
        return listPokemon;
    }

    public static boolean isDeadLock(ArrayList<ArrayList<pokemon>> listPokemon,int[][]map){
        for(int i = 1 ; i < 37; i++){
//            System.out.println("=================================");
            for(int j = 0 ; j < listPokemon.get(i).size(); j++){
                pokemon point1 = listPokemon.get(i).get(j);
                for(int k = j + 1; k < listPokemon.get(i).size(); k++){
//                    System.out.print("check: ");
//                    System.out.print("("+listPokemon.get(i).get(j).id+" , "+listPokemon.get(i).get(j).rowIndex+" , "+listPokemon.get(i).get(j).colIndex+")");
//                    System.out.print(" => ");
//                    System.out.print("("+listPokemon.get(i).get(k).id+" , "+listPokemon.get(i).get(k).rowIndex+" , "+listPokemon.get(i).get(k).colIndex+")");
                    pokemon point2 = listPokemon.get(i).get(k);
                    if(Matching.checkTwoPoint(map, point1.rowIndex, point1.colIndex, point2.rowIndex, point2.colIndex).length == 2){
//                        System.out.println(" can continue Fucking the game!");
                        return false;
                    }
                }
//                System.out.println();
            }
//            System.out.println("=================================");
        }
        System.out.println(" Can't continue *beep* the game!");
        return true;
    }

    public static void main(String[] args) {
        int[][] mapDefault = new int[11][];
        mapDefault[0] = new int[]{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0};
        mapDefault[1] = new int[]{0,  0,  5,  2,  7,  2,  3,  8,  4,  1,  5,  10, 14, 19, 23, 28, 32, 0};
        mapDefault[2] = new int[]{0,  5,  1,  6,  6,  3,  7,  4,  8,  1,  6,  10, 15, 29, 24, 28, 33, 0};
        mapDefault[3] = new int[]{0,  9,  10, 9,  10, 11, 15, 12, 12, 2,  6,  11, 16, 20, 24, 19, 34, 0};
        mapDefault[4] = new int[]{0,  13, 13, 14, 14, 15, 11, 16, 16, 2,  7,  12, 16, 20, 25, 29, 33, 0};
        mapDefault[5] = new int[]{0,  17, 21, 18, 19, 18, 23, 3,  20, 3,  20, 12, 15, 21, 21, 30, 34, 0};
        mapDefault[6] = new int[]{0,  21, 17, 22, 22, 27, 19, 24, 24, 7,  8,  11, 17, 25, 26, 30, 31, 0};
        mapDefault[7] = new int[]{0,  25, 30, 26, 4,  23, 27, 28, 28, 26, 35, 17, 13, 22, 26, 8,  35, 0};
        mapDefault[8] = new int[]{0,  29, 33, 30, 34, 31, 35, 32, 32, 4,  9,  13, 18, 22, 27, 31, 32, 0};
        mapDefault[9] = new int[]{0,  33, 29, 25, 34, 35, 31, 36, 36, 5,  9,  14, 18, 23, 27, 36, 36, 0};
        mapDefault[10]= new int[]{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0};

        ArrayList<ArrayList<pokemon>> listPokemon = initStatusMap(mapDefault);

        for(int i = 0 ; i < listPokemon.size();i++){
            for(int j = 0; j < listPokemon.get(i).size(); j ++){
                System.out.print("("+listPokemon.get(i).get(j).id+" , "+listPokemon.get(i).get(j).rowIndex+" , "+listPokemon.get(i).get(j).colIndex+")");
            }
            System.out.println();
        }
        if(!isDeadLock(listPokemon,mapDefault)){
            System.out.println("OK! continue!");
        }else {
            System.out.println("Bế tắc, trộn lại!");
        }
        listPokemon = updateStatusMap(listPokemon,1,1,9,2,2);
        System.out.println("After update:");
        for(int i = 0 ; i < listPokemon.size();i++){
            for(int j = 0; j < listPokemon.get(i).size(); j ++){
                System.out.print("("+listPokemon.get(i).get(j).id+ " , " + listPokemon.get(i).get(j).rowIndex + " , " + listPokemon.get(i).get(j).colIndex + ")");
            }
            System.out.println();
        }
    }
}


