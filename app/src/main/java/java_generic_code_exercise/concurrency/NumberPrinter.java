package java_generic_code_exercise.concurrency;

public class NumberPrinter implements Runnable{

    int number;

    NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is printing number: " + number);
    }

    public static void main(String[] args) {
        for(int i=0; i<=100; i++){
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }
    }
}
