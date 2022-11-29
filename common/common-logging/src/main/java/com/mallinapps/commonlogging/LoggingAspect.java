package com.mallinapps.commonlogging;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllersLayer() {
        //method is empty because it's a pointcut
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void servicesLayer() {
        //method is empty because it's a pointcut
    }

    @Pointcut("@annotation(com.mallinapps.commonlogging.Loggable)")
    public void loggableMethod() {
        //method is empty because it's a pointcut
    }

    @Pointcut("servicesLayer() && loggableMethod()")
    public void loggableServiceMethod() {
        //method is empty because it's a pointcut
    }

    @Before("controllersLayer()")
    public void logControllerMethod(final JoinPoint joinPoint) {
        final Map<String, Object> parameters = getParameters(joinPoint);
        log.info("{}, arguments: {} ", joinPoint.toShortString(), parameters);
    }

    @AfterReturning(pointcut = "loggableMethod()", returning = "returnedValue")
    public void logServiceMethodAfter(final JoinPoint joinPoint, final Object returnedValue) {
        final Map<String, Object> parameters = getParameters(joinPoint);
        final StringBuilder toLog = new StringBuilder(joinPoint.toShortString()).append(", arguments: ").append(parameters);
        if (shouldLogReturnValue(joinPoint)) {
            toLog.append(", returned value: ").append(returnedValue);
        }
        log.info(toLog.toString());
    }

    private Map<String, Object> getParameters(final JoinPoint joinPoint) {
        final String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        final Object[] args = joinPoint.getArgs();
        return IntStream.range(0, paramNames.length)
                .collect(HashMap::new, (map, index) -> map.put(paramNames[index], args[index]), HashMap::putAll);
    }

    private boolean shouldLogReturnValue(final JoinPoint joinPoint) {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Loggable annotation = signature.getMethod().getAnnotation(Loggable.class);
        return annotation.logReturnValue();
    }

}
