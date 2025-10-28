package org.introduction_to_AOP_with_spring.meeting_of_the_intercepting_council;

public class ErrorBean {
    public void errorProneMethod() throws Exception{
        throw new Exception("Generic Exception");
    }
    public void otherErrorProneMethod() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalArgument Exception");
    }
}
