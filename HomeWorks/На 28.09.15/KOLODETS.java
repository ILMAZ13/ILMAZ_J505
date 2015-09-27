class KOLODETS {
    public static void main(String[] args) {
        double t=Double.valueOf(args[0]), g=9.8,h;
        h=g*t*t/2;
        System.out.print("После броска камня, вы услышали всплеск через "+String.valueOf(t)+" секунд. Значит, глубина колодца =");
        System.out.println(String.valueOf(h)+" метров.");
    }
} 