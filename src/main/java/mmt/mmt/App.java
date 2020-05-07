package mmt.mmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.*;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan("mmt")
public class App 
{
    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
