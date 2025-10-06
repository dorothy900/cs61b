package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Main.drawTriangle(10);
        //int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        //System.out.println(Main.max(numbers));
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        for(int num:a){
            System.out.print(num+" ");
        }


    }
    public static void drawing(){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void drawTriangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int largest=0;
        for(int i=0;i<m.length;i++){
            if (m[i]>largest){
                largest=m[i];
            }
        }
        return largest;
    }
    public static void windowPosSum(int[] a, int n){
       for(int i=0;i<a.length;i++){
           if (a[i]>0){
               for(int j=i+1;j<=i+n;j++){
                   if (j==a.length){
                       break;
                   }
                   a[i]+=a[j];
               }
           }

       }
    }


}