package dsaPrateek.lecture6ArraysII;

import java.util.Arrays;
/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays that represent the arrival and departure times of trains that stop.
Examples:
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 11:00 to 11:20)
Input: arr[] = {9:00, 9:40}
dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.
 */
public class MinimumNumberOfPlatforms {
    private int minNumberOfPlatsForms(int[] a, int[] b){
        int i  = 0,j = 0,counter = 0;
        Arrays.sort (a);
        Arrays.sort (b);
        while(i<a.length){
            if(a[i] < b[j]){ // arrival train is coming, so it needs platform
                counter++;
            }else{ // some train departed. so we can use that space
                j++;
            }
            i++;// give a way to next arrival
        }

        return counter <= 0 ? 1 : counter;
    }
    public static void main(String[] args) {
        MinimumNumberOfPlatforms minimumNumberOfPlatforms = new MinimumNumberOfPlatforms();
        //   int a[] = {900, 940, 950, 1100, 1500, 1800}, b[] = {910, 1200, 1120, 1130, 1900, 2000};
        //  int a[] = {900,940},b[] ={910,1200};
        // int a[] = { 200, 210, 300, 320, 350, 500},b[]={ 230, 340, 320, 430, 400, 520};
        int a[] = { 910, 1200,1225,1238,1241, 1242,1243},b[]={ 1100, 1230,1235,1330,1345,1346,1347};
        System.out.println ("MinPlatForms:" +minimumNumberOfPlatforms.minNumberOfPlatsForms(a,b));
    }
}