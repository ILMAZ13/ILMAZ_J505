class INTEGRAL {
    public static void main(String[] args) {
        double x1=Double.valueOf(args[0]),x2=Double.valueOf(args[1]),s=0.0,xd,xn,xk,yn,yk,sum=0.0;
        int n=Integer.valueOf(args[2]),i;
        
        if ((x1>x2) || (n<1)) {                                         //Проверка на некоррекность ввода
            System.out.println("Введенные параметры неверны");
        }
        else {
            xn=x1;                                                      //Назначаем первую вершину тропеции
            xd=(x2-x1)/n;                                               //Находим шаг продвижения
            xk=xn+xd;                                                   //Назначаем вторую вершину тропеции
            for (i=1;i<=n;i++) {
                yn=(xn*xn)+(8.0*xn);                                    //Находим длины 
                yk=(xk*xk)+(8.0*xk);                                    //оснований
                s=((yn+yk)/2.0)*xd;                                     //Площадь тропеции
                sum=sum+s;                                              //Суммируем
                xn=xk;                                                  //Перемещаем вершины
                xk=xk+xd;                                               //тропеции
            }
            System.out.println("Интеграл для функции Y=X^2+8X на отрезке "+String.valueOf(x1)+" "+String.valueOf(x2)+" равен "+String.valueOf(sum)); //Вывод
        }
    }
}