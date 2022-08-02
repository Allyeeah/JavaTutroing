public class Calculator {
    public static int add(int a, int b){
        return a += b;
    }

    public static void add2(Test a, Test b){
        a.num = a.num + b.num;

    }
}

class Test{
    public int num;

}