class CIRCLE
{
    public static void main(String[] args) {
        int a=Integer.valueOf(args[0]), b=Integer.valueOf(args[1]),r,rad=Integer.valueOf(args[2]); //Вводятся координаты точки и радиус окружности
        rad = rad*rad;
        r = (a-0)*(a-0) + (b-0)*(b-0); //Уравнение окружности, при необходимости можно перенести центр окр-ти, поменяв нули на координаты центра
        if (r>rad) {
            System.out.println("Вне окружности");
        } 
        else {
             if (r<rad){
                 System.out.println("Внутри окружности");
             } 
             else {
                 System.out.println("Лежит на окружности");
             }
        }
        
        
    }
}
