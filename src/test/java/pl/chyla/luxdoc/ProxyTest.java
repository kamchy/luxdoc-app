package pl.chyla.luxdoc;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    interface Doer {
        void doIt();
        void doSomething();
    }
    class Simple  implements Doer {

        @Override
        public void doIt() {
            System.out.println("it");
        }

        @Override
        public void doSomething() {
            System.out.println("something");
        }
    }

    class MyProxy implements InvocationHandler {

        private final Simple wrapped;

        public MyProxy(Simple simple) {
            wrapped = simple;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("--- before ---");
            method.invoke(wrapped, args);
            System.out.println("--- after --");
            return wrapped;
        }


    }

    @Test
    public void name() throws Exception {
         Doer doer = (Doer) Proxy.newProxyInstance(Simple.class.getClassLoader(),
                 new Class[]{Doer.class},
                 new MyProxy(new Simple())
                 );

        doer.doIt();
        doer.doSomething();

    }
}
