package singletonSecond;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum ServiceLocator {
    INSTANCE;
    private final Map<Class<?>, Object> services = new ConcurrentHashMap<>();
//    {
//        services.put(EmailService.class, new EmailService());
//        services.put(PaymentService.class, new PaymentService());
//    }

    @SuppressWarnings("unchacked")
    public <T> T getService(Class<T> clazz) {
//        T t = (T) services.get(clazz);
//        if (t == null) {
//            T value = clazz.getDeclaredConstructor().newInstance();
//            services.put(clazz, value);
//            return value;
//        }
//        return t;
        return (T) services.computeIfAbsent(clazz, this::createInstance);
    }

    private <T> T createInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create service: " + clazz.getName(), e);
        }
    }
}
