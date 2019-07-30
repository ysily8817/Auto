package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication
public class Application {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> d430e3c113aaab34ebcce6797d9cc82974262990
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class,args);
<<<<<<< HEAD
=======
=======

    private static ConfigurableApplicationContext context;

    public static void main(String args[]) {
        Application.context = SpringApplication.run(Application.class, args);
>>>>>>> 57b2b145dde501fb9c095c864fff2acf276d99aa
>>>>>>> d430e3c113aaab34ebcce6797d9cc82974262990
    }

    @PreDestroy
    public void close() {
        Application.context.close();
    }
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> 57b2b145dde501fb9c095c864fff2acf276d99aa
>>>>>>> d430e3c113aaab34ebcce6797d9cc82974262990
}
