class prog3
{
     public static void main(String[] args) {
     int i,j,r;
     String i1;
     String j1;
     String s,r1;
     for (i=1; i<10; i++) {
          for (j=1; j<10; j++) {
          i1=String.valueOf(i); //поменял местами i и j
          j1=String.valueOf(j); //так луччше))
          r=i*j;
          r1=String.valueOf(r);
          s=j1+"x"+i1+"="+r1+" ";
          if (r<10) {
          s=s+" ";
          }
     System.out.print(s);
          }
          System.out.println();
     }
}
}