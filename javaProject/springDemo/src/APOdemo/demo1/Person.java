package APOdemo.demo1;

public class Person implements action{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
