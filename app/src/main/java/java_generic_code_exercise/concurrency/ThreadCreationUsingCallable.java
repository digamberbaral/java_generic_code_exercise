package java_generic_code_exercise.concurrency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadCreationUsingCallable implements Callable<BigDecimal> {

    private final List<BigDecimal> priceList = List.of(
            new BigDecimal("4"), 
            new BigDecimal("5"), 
            new BigDecimal("45.25"), 
            new BigDecimal("89.31"), 
            new BigDecimal("89.03"), 
            new BigDecimal("56.07"), 
            new BigDecimal("49.33")
    );

    @Override
    public BigDecimal call() throws Exception {
        return null;
    }

    public static void main(String[] args) {

    }
}
