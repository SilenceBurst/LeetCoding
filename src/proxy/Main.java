package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
//        staticProxy();

//        jdkDynamicProxy();

        viewJdkProxy();
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
