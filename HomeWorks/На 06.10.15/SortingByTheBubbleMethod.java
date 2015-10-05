import java.util.Scanner;
import java.util.Arrays;

class SortingByTheBubbleMethod {
    public static void main(String[] args) {
    
        //reading of the number of elements, and validation of the entered data
        System.out.println("Enter the number of items for sorting");
        boolean intering = true;
        int     n = 0;
        while (intering) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            if (n < 2) {
                System.out.println("Please enter a value greater than 1");
            }
            else {
                intering = false;
            }
        }
        
        //random assignment of values
        int[] a = new int [n];
        int   i;
        for (i = 0; i < n; i++) {
            a[i] = (int) Math.round(Math.random()*1000);
        }
        if (n <= 50) {
            System.out.println("Received random values:");
            System.out.println(Arrays.toString(a));
        }
        else {
            System.out.println("Too many values to display");
        }
        
        //Sorting by the bubble method(countable-uncountable)
        boolean flag1 = true;
        boolean flag2 = true;
        int     steps = 0;
        int     j;
        int     k;
        int     n1 = n - (n % 2);
        int     n2 = n + (n % 2) -1;
        i = 1;
        while (flag1 || flag2) {
            if (i % 2 == 1) {
                flag1 = false;
                for (j=0; j < n1; j = j + 2) {
                    if (a[j] > a[j+1]) {
                        k      = a[j];
                        a[j]   = a[j+1];
                        a[j+1] = k;
                        flag1  = true;
                    }
                    steps++;
                } 
            }
            else {
                flag2 = false;
                for (j = 1; j < n2; j = j + 2) {
                    if (a[j] > a[j+1]) {
                        k      = a[j];
                        a[j]   = a[j+1];
                        a[j+1] = k;
                        flag2  = true;
                    }
                    steps++;
                }
            }
            i++;
        }
        
        //outputting the result of of sorting
        System.out.println("******************************************************");
        System.out.println("Elements successfully sorted in "+String.valueOf(steps)+" steps:");
        System.out.println(Arrays.toString(a));
    }
}