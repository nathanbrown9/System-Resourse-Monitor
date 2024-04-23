// import statements
package com.example.myresourceMonitor.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import com.example.myresourceMonitor.model.SystemInfo;
import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


// using @RestController to map html pages to our java functions
@RestController
public class SystemResourceController {


    // this get mapping, maps the html page to springboot
    // this allows our java functions to interact with springboot
    @GetMapping("/cpu-usage")
    public static String getCpuUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/cpu_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    
    }

    // post mapping allows us to preform actions with clicking on the button
    // here we map our process cpu load to the button click and it returns the value of the function
    @PostMapping("/cpu-usage-click")
    public static double CPU_click() {
        return SystemInfo.getProcessCpuLoad();
    }
    
    // this maps our disk usage to our html page, same code as prior
    @GetMapping("/disk-usage")
    public static String getDiskUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/disk_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
    
    // this maps our io function to clicking the button, same code as prior
    @PostMapping("/disk-usage-click")
    public static String DISK_click() {
        return SystemInfo.getSystemLoadAverage();
    }
    
    // this maps our memory usage to our html page, same code as prior
    @GetMapping("/memory-usage")
    public static String getMemoryUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/memory_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    // this maps our memory usage function to clicking the button, same code as prior
    @PostMapping("/memory-usage-click")
    public static String[] MEMORY_click() {
        return SystemInfo.getMemory();}
    
    // this maps our bandwidth to our html page, same code as prior
    @GetMapping("/bandwidth")
    public static String getBandwidth() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/bandwidth.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        }
    
    // this maps our bandwidth function to clicking the button, same code as prior
    @PostMapping("/bandwidth-click")
    public static String bandwidth_click() throws SocketException {
        return SystemInfo.getNetworkIncoming();
    }
}
