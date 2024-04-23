// import statements
package com.example.myresourceMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this allows us to run our springboot application
// running this file allows for everything to start
@SpringBootApplication
public class SystemResourceMonitorApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemResourceMonitorApplication.class, args);
	}
}

