package abound.core;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DependencyContainer
{
    private static final Map<Class<?>, Object> singletonMap = new ConcurrentHashMap<>();

    public static <T> T getBean(Class<T> clazz) {
        try {
            if (!singletonMap.containsKey(clazz)) {
                // Recursive constructor injection
                T instance = createInstance(clazz);
                singletonMap.put(clazz, instance);
            }
            return clazz.cast(singletonMap.get(clazz));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get bean for: " + clazz.getName(), e);
        }
    }

    private static <T> T createInstance(Class<T> clazz) throws Exception {
        // Support constructor injection with dependencies
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] dependencies = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                dependencies[i] = getBean(paramTypes[i]); // recursive resolution
            }
            return (T) constructor.newInstance(dependencies);
        }
        throw new IllegalStateException("No suitable constructor found for " + clazz.getName());
    }
}
