class ROMB
{
    public static void main(String[] args) {
        int a=Integer.valueOf(args[0]),i,j,k,o,p;
        if (a<3) {
            System.out.println("Введите значение, не меньше 3");
        } 
        else {
            String s="";
            p=-1;
            if (a%2==1){
                k=a/2;
                o=1;
            } 
            else {
                k=a/2-1;
                o=2;
            } 
            for (i=1; i<=a; i++ ) {
                for (j=1; j<=k; j++) {
                    s=s+"X";
                }
                if ((k!=0) || ((k==0) && (a%2==0))){
                    if (p==-1) {
                        s=s+"/";
                    } 
                    else {
                        s=s+"\\";
                    }
                }
                else {
                    s=s+"(";
                }
                for (j=1; j<=o; j++) {
                    s=s+"O";
                }
                if ((k!=0) || ((k==0) && (a%2==0))){
                    if (p==-1) {
                        s=s+"\\";
                    } 
                    else {
                        s=s+"/";
                    }
                }
                else {
                    s=s+")";
                }
                for (j=1; j<=k; j++) {
                    s=s+"X";
                }
                System.out.println(s);
                s="";
                if (k==0) {
                    p=1;
                }
                k=k+p;
                o=o-(2*p);
                if ((i == (a/2)) && (a%2==0)) {
                    k=k-1;
                    o=o+2;
                }
            }
        }
    }
}
