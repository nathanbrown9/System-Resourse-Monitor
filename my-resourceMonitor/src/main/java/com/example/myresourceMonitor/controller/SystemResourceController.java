package com.example.myresourceMonitor.controller;

import com.example.myresourceMonitor.model.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemResourceController {

    @Autowired
    private SystemInfo systemInfo;

    @GetMapping("/cpu-usage")
    public String getCpuUsage(){
        return "Cpu Usage " + systemInfo.getProcessors() +"%";
    }
    @GetMapping("/disk-usage")
    public String getDiskUsage(){
        return "Disk Usage " + systemInfo.getSystemLoadAverage();
    }
    @GetMapping("/memory-usage")
    public String getMemoryUsage(){
        return "Memory Usage " + systemInfo.getMemoryUsageGB()+"GB";
    }
}
