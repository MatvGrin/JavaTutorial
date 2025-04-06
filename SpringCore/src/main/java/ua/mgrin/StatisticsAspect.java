package ua.mgrin;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;

@Aspect
public class StatisticsAspect {
    private Map<Class<?>, Integer> counter;

    @AfterReturning("allLogEventMethods()")
    public void count(JoinPoint jp){
        Class<?> clazz = jp.getTarget().getClass();
        if(!counter.containsKey(clazz)){
            counter.put(clazz, 0);
        }
        counter.put(clazz, counter.get(clazz)+1);
    }

    @Around("consoleLoggerMethods() && args(evt)")
    public void aroundLogEvent(ProceedingJoinPoint jp, Event evt){
        if (evt != null){
            try {
                System.out.println("Executing method with event: " + evt);
                jp.proceed(new Object[] {evt});
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Event is null, handling it with a different logger.");
            EventLogger otherLogger = new ConsoleEventLogger();
            otherLogger.logEvent(evt);
        }

    }
}
