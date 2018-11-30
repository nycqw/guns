package cn.stylefeng.guns.core.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author chenqw
 * @since 2018/11/30
 */
public class AopUtil {

    public static Method getTargetMethod(JoinPoint point) throws NoSuchMethodException {
        Signature signature = point.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        // 目标类对象
        Object target = point.getTarget();
        return target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    public static String getParams(JoinPoint point) {
        Object[] params = point.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(" & ");
        }
        return params.toString();
    }

}
