
    

    import java.util.*;

    public class exitPointS {
    
    public static void printExitPoint(int[][] arr) {
        int dir = 0;
        // source point
        int r = 0;
        int c = 0;

        while(r >= 0 && r < arr.length && c >= 0 && c < arr[0].length) {
            // direction management
            dir = (dir + arr[r][c]) % 4;

            // moves management
            if(dir == 0) {
                c++;
            } else if(dir == 1) {
                r++;
            } else if(dir == 2) {
                c--;
            } else {
                r--;
            }
        }
        // management of invalid coordinate
        if(dir == 0) {
            c--;
        } else if(dir == 1) {
            r--;
        } else if(dir == 2) {
            c++;
        } else {
            r++;
        }

        //System.out.println(r + ", " + c);
        System.out.println(r);
        System.out.println(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int [][] arr = new int[r][c];
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
              arr[i][j] = sc.nextInt();  
            }
        }
        printExitPoint(arr);
    }    
}
