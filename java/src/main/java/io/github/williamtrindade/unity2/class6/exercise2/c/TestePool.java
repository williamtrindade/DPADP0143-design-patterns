package io.github.williamtrindade.unity2.class6.exercise2.c;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class TestePool {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        new TestePool().init();
    }

    private void init() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pool pool = PoolGenerico.getInstance(Object.class);
        for (int i = 0; i < 40; i++) {
            new Thread(new TesteRunnable(pool)).start();
        }
    }

    private class TesteRunnable implements Runnable {

        private Random rnd = new Random();
        private Pool pool;

        private TesteRunnable(Pool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            Object oPool = null;
            while (true) {
                if (oPool != null) {
                    pool.release(oPool);
                    oPool = null;
                } else {
                    try {
                        oPool = pool.acquire();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep((int) (rnd.nextFloat() * 1000));
                } catch (InterruptedException e) { }
            }
        }
    }

}
