class prog2
{
     public static void main(String[] args) {
     double a=Double.valueOf(args[0]),b=Double.valueOf(args[1]),c=Double.valueOf(args[2]),d;
     double r1,r2;
     d=b*b-(4*c*a);
     if (d==0) {
     r1=(0-b)/(2*a);
     System.out.println(r1);
     } 
     else {
     if (d>0) {
     r1=(0-b+Math.sqrt(d))/(2*a);
     r2=(0-b-Math.sqrt(d))/(2*a);
     System.out.println(r1);
     System.out.println(r2);
     }
     else {
     System.out.println("Нет корней");
     }
     }
     
     
}
}