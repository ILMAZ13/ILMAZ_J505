///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package algo;
//
//import java.util.Scanner;
//
///**
// *
// * @author ILMAZ
// */
//public class Floid {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] a = new int[n][n];
//        for(int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
//                a[i][j] = sc.nextInt();
//                if(a[i][j] == -1){
//                    a[i][j] = 999998;
//                }
//            }
//        }
//        for (int k = 0; k < n ; k++){
//            for(int i = 0; i < n; i++){
//                for (int j = 0; j < n; j++){
//                    a[i][j] = Math.min(a[i][j], a[i][k]+a[k][j]);
//                }
//            }
//            print(a,n,k);
//        }
//    }
//    static void print(int[][] a, int n, int k){
//        System.out.println();
//        System.out.println(k+1);
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(a[i][j] == 999998){
//                    System.out.print("∞ ");
//                }
//                else {
//                    System.out.print(a[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
//}
