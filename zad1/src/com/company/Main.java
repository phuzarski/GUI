package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads()) System.out.println(t.getName());
    /*<- tu uruchomić
         wszystkie kody w wątkach
     */
        letters.startThreads();
        Thread.sleep(5000);
        letters.abortThreads();

    /*<- tu trzeba zapisać
       fragment, który kończy działanie kodów, wypisujących litery
    */
        System.out.println("\nProgram skończył działanie");
    }
}
