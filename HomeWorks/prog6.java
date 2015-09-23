class prog6
{
     public static void main(String[] args) { 
     int i,n=Integer.valueOf(args[0]);
     double s=0.0,x=Double.valueOf(args[1]);
     for (i=1;i<=n;i++){
        s=Math.cos(x+s);
     }
     System.out.println(s);
}
}