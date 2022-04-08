package proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cgLib代理：找客户");
        System.out.println("cgLib代理：看房");
        System.out.println("cgLib代理：拟定合同");
        return methodProxy.invokeSuper(o, args);
    }
}
