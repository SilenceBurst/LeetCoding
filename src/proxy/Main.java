package proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
//        staticProxy();

//        jdkDynamicProxy();

//        viewJdkProxy();

        cgLibProxy();
    }

    private static void cgLibProxy() {
        // 动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 要代理的类
        enhancer.setSuperclass(Owner2.class);
        // CgLibProxy的intercept中对原对象方法扩展
        enhancer.setCallback(new CgLibProxy());
        // 创建代理对象
        Owner2 proxy = (Owner2) enhancer.create();
        // 调用代理对象方法
        proxy.saleHouse();
    }

    private static void jdkDynamicProxy() {
        Owner owner = new Owner();
        IService proxy = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class[]{IService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态中介：找客户");
                        System.out.println("动态中介：看房");
                        System.out.println("动态中介：拟定合同");
                        owner.saleHouse();
                        return null;
                    }
                });
        proxy.saleHouse();
    }

    private static void staticProxy() {
        OwnerProxy ownerProxy = new OwnerProxy(new Owner());
        ownerProxy.saleHouse();
    }

    private static void viewJdkProxy() {
        byte[] classFile = ProxyGenerator.generateProxyClass("JdkProxy", new Class[]{IService.class});
        String path = "/Users/sign/Desktop/JdkProxy.class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("文件写入成功");
        } catch (Exception e) {
            System.out.println("文件写入失败");
        }
    }
}
