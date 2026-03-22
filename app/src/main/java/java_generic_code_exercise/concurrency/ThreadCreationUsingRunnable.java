package java_generic_code_exercise.concurrency;

public class ThreadCreationUsingRunnable implements Runnable{

    private int counter = 0;

    ThreadCreationUsingRunnable(int counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Thread is running with counter value: " + counter);
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(() -> System.out.println("Processing In : " + Thread.currentThread().getName()));
        System.out.println("Before thread Execution Start : {} " + t.getState());
        t.start();
        System.out.println("After thread Execution Start : {} " + t.getState());

        t.join();
        System.out.println("After Calling Join : {} "+ t.getState());

    }
}
