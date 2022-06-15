//package io.github.williamtrindade.unity2.class6.exercise2.c;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.Random;
//
//public class Test {
//    public static void main(String[] args) {
//
//    }
//
//    private void init() {
//        Pool pool = GenericPool.getInstance(Object.class);
//        for (int i = 0; i < 40; i++) {
//            new Thread(new TestRunnable(pool)).start();
//        }
//    }
//    private class TestRunnable implements Runnable{
//
//        private Random rnd = new Random();
//
//        private Pool pool;
//
//        private TestRunnable(Pool pool) {
//            this.pool = pool;
//        }
//
//        @Override
//        public void run() {
////            Object oPool = null;
////            while (true) {
////                if (oPool!+null) {
////                    this.pool.release(oPool);
////                } else {
////                    try {
////                        oPool = this.pool.acquire();
////                    } catch (NoSuchMethodException e) {
////                        throw new RuntimeException(e);
////                    } catch (InvocationTargetException e) {
////                        throw new RuntimeException(e);
////                    }
////                }
////                Thread.sleep((int) (rnd.nextFloat() * 1000));
////            }
//        }
//    }
//
//}
