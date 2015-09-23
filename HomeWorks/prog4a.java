class prog4a
{
     public static void main(String[] args) { 
          double x=Double.valueOf(args[0]);
          double y=Double.valueOf(args[1]);
          double d1,d2,d3,d4;
          d1=x*x*x*x*x*x+y*y*y*y*y*y*y-37.0;
          d2=(4.0/3.0)+((5.0*x)/2.0)-74.0;
          d3=(y*y)/2.0;
          d4=d1/d2+d3-(x*y);
          System.out.println(d4);
     }
}
