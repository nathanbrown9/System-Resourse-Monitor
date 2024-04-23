package com.example.myresourceMonitor.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import com.example.myresourceMonitor.model.SystemInfo;

import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SystemResourceController {

    @Autowired
    private SystemInfo systemInfo;

  

    @GetMapping("/cpu-usage")
    public static String getCpuUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/cpu_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    
    }
    @PostMapping("/cpu-usage-click")
    public static double CPU_click() {
    // Start monitoring process or perform any other action
        return SystemInfo.getProcessCpuLoad();
    }
    
    @GetMapping("/disk-usage")
    public static String getDiskUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/disk_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
    
    @PostMapping("/disk-usage-click")
    public static String DISK_click() {
    // Start monitoring process or perform any other action
        return SystemInfo.getSystemLoadAverage();
    }
    
    @GetMapping("/memory-usage")
    public static String getMemoryUsage() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/memory_usage.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @PostMapping("/memory-usage-click")
    public static String[] MEMORY_click() {
    // Start monitoring process or perform any other action
        return SystemInfo.getMemory();}
    
    @GetMapping("/bandwidth")
    public static String getBandwidth() throws IOException{
        ClassPathResource resource = new ClassPathResource("static/bandwidth.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        }
    
    @PostMapping("/bandwidth-click")
    public static String bandwidth_click() throws SocketException {
    // Start monitoring process or perform any other action
        return SystemInfo.getNetworkIncoming();
    }
}
