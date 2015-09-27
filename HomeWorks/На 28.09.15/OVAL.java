class OVAL {
    public static void main(String[] args) {
        int i,j,rx=Integer.valueOf(args[0]), ry=Integer.valueOf(args[1]); //Считываю 1-ый и 2-ой радиусы
        String s="";
        double r,rxd=Double.valueOf(rx),ryd=Double.valueOf(ry);           //Задаю радиусы в double, для более точного результата при делении
        
        if ((rx<1) || (ry<1)) {                                           //Проверка на неотрицательность радиусов
            System.out.println("Введите значения больше нуля");  
        }
        else {
            if (ry > rx) {                                                //Рассматриваю 2 варианта, когда радус по оси у больше или меньше(равно)
                r=ryd*ryd+1;                                              //Сразу вычисляю r^2/ +1 потому что не берет крайние при малых числах
                for (i=0;i<=(2*ry);i++) {                                 //2 цикла, по оси х и у
                    for (j=0;j<=(2*rx);j++) {
                        if ((((ryd/rxd)*(rxd-j))*((ryd/rxd)*(rxd-j)))+((ryd-i)*(ryd-i))<r) {    //Переделал уравнение окружности для эллипсиса, умножая один из переменных на число
                            s=s+"O";                                                            //Если точка с координатами i,j лежит внутри эллипсиса, то прибавляем символ "О"
                        }
                        else {
                            s=s+"_";                                                            //Иначе, черта
                        }
                    }
                    System.out.println(s);                                                      //Вывожу строку
                    s="";                                                                       //И обнуляю его
                }
            }
            else {                                                                              //Те же операции, только везде х поменял на у
                r=rxd*rxd+1;
                for (i=0;i<=(2*ry);i++) {
                    for (j=0;j<=(2*rx);j++) {
                        if ((((rxd/ryd)*(ryd-i))*((rxd/ryd)*(ryd-i)))+((rxd-j)*(rxd-j))<r) {
                            s=s+"O";
                        }
                        else {
                            s=s+"_";
                        }
                    }
                    System.out.println(s);
                    s="";
                }
            }        
        }
    }
}