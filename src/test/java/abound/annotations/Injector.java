package abound.annotations;

import abound.core.DependencyContainer;

import java.lang.reflect.Field;

public class Injector
{
    public static void inject(Object testInstance) {
        for (Field field : testInstance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoWire.class)) {
                field.setAccessible(true);
                Object dependency = DependencyContainer.getBean(field.getType());
                try {
                    field.set(testInstance, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Injection failed for: " + field.getName(), e);
                }
            }
        }
    }
}
