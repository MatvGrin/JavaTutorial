package singletonSecond;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class ProducerConsumer {

    public static void main(String[] args) {

//        Store store = new Store();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute(new Producer(store));
//        executorService.execute(new Consumer(store));
//
//        executorService.shutdown();


        int sss = ForkJoinPool.getCommonPoolParallelism();
        System.out.println(sss);

        
    }
}