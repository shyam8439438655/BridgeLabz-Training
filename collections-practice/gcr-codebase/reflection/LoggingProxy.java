import java.lang.reflect.*;

public class LoggingProxy {

    interface Greeting {
        String sayHello(String name);
    }

    static class GreetingImpl implements Greeting {
        public String sayHello(String name) {
            return "Hello, " + name;
        }
    }

    public static void main(String[] args) {
        Greeting target = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new InvocationHandler() {
                    public Object invoke(Object proxyObj, Method method, Object[] methodArgs) throws Throwable {
                        System.out.println("[LOG] Calling method: " + method.getName());
                        return method.invoke(target, methodArgs);
                    }
                }
        );

        System.out.println(proxy.sayHello("Rahul"));
    }
}
