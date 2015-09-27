class NOD {
    public static void main(String[] args) {
        int a=Integer.valueOf(args[0]),b=Integer.valueOf(args[1]),s;
        
        while ((a!=0) && (b!=0)) {
            if (a>=b) {
                a=a%b;
            }
            else {
                b=b%a;
            }
        }
        s=a+b;
        System.out.println(s);
    }
}