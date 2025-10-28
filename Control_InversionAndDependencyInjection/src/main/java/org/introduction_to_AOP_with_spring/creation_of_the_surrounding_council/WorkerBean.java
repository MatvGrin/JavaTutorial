package org.introduction_to_AOP_with_spring.creation_of_the_surrounding_council;

public class WorkerBean {
    public void doSomeWork(int noOfTimes){
        for (int i = 0; i < noOfTimes; i++) {
            work();
        }
    }
    public void work(){
        System.out.println("");
    }
}
