package com.company;

public class Letters {

    public Thread[] threads;
    boolean isRunning = true;

    public Letters(String letters) {
        threads = new Thread[letters.length()];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new LettersRunnable(letters.charAt(i)), "Thread " + letters.charAt(i));
        }
    }

    public Thread[] getThreads() {
        return threads;
    }

    public void startThreads() {
        isRunning = true;
        for (Thread t : threads) {
            t.start();
        }
    }

    public void abortThreads() {
        isRunning = false;
    }

    private class LettersRunnable implements Runnable {
        char c;

        private LettersRunnable(char c) {
            this.c = c;
        }

        @Override
        public void run() {
            while (isRunning) {
                System.out.print(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
