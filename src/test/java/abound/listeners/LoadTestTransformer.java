package abound.listeners;

import abound.annotations.LoadTest;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LoadTestTransformer implements IAnnotationTransformer
{

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method)
    {
        if(method != null && method.isAnnotationPresent(LoadTest.class))
        {
            LoadTest loadTest = method.getAnnotation(LoadTest.class);

            int invocatonCount = loadTest.invocationCount();
            int threadCount = loadTest.threadPoolSize();

            iTestAnnotation.setInvocationCount(invocatonCount);
            iTestAnnotation.setThreadPoolSize(threadCount);
            iTestAnnotation.setEnabled(loadTest.enabled());
            iTestAnnotation.setDescription(loadTest.description());
            iTestAnnotation.setGroups(loadTest.groups());

        }

    }
}
