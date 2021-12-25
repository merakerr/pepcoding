/*
1. Question will be provided with "n" meeting-schedules. A meeting-schedule is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an meeting. Some meeting-schedules may or maynot overlap each other.
2. MeetingIntervals[i] = [startingPointi,endingPointi]
3. A meeting-schedule represents meeting time(i.e. starting time & ending time).

Task is to "figure out, whether is it possible to attend all meetings or not".
*/
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Scanner;
    
    
    public class meetingRoom1 {
        public static boolean meetingRooms(int arr[][]){
            if(arr.length == 0){
                return true;
            }
            Arrays.sort(arr, (val1, val2)->Integer.compare(val1[0], val2[0]));
            int st = arr[0][0];
            int end = arr[0][1];
            for(int i = 1; i < arr.length; i++){
                int st_pt = arr[i][0];
                int end_pt = arr[i][1];
                if(end <= st_pt){
                    st = st_pt;
                    end = end_pt;
                }else{
                    return false;
                }
            }
            return true;
        }
        public static void main(String args[]){
            Scanner scn = new Scanner(System.in);
    
            // Input Format
            int n = scn.nextInt();
            int input[][] = new int[n][2];
    
            for(int i = 0 ; i <  n ; i++){
                int sp = scn.nextInt();
                int ep = scn.nextInt();
    
                input[i][0] = sp;
                input[i][1] = ep;
            }
    
            // Output Format
            boolean res = meetingRooms(input);
            System.out.println(res);
        }
    }
