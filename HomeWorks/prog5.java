class prog5
{
     public static void main(String[] args) { 
        int n=Integer.valueOf(args[0]);
        int i,p=-1;
        double d=1.0,s=0, k=1;
        for (i=1;i<=n;i++){
            s=s+k*(1.0/(d*d));
            k=k*p;
            d=d+2.0;
        }
        System.out.println(s);
     }
}