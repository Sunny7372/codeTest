package com.filedownload;

public class Coding {
    public static void main(String[]args){
        int[]arr={1,2,3,4,6,7, 8,9,10};
        /*for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]!=1){
                int missingNumber=arr[i]+1;
                System.out.println(missingNumber);

            }


            }*/
        int n=10;

        int total_sum=n*(n+1)/2;
        int actual_sum=0;
        for(int num:arr){
            actual_sum=actual_sum+num;

        }
        int missing_number=total_sum-actual_sum;
        System.out.println(missing_number);

    }
}


