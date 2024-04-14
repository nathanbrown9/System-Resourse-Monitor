package com.example.myresourceMonitor.model;
import org.springframework.stereotype.Component;
@Component
public class SystemResourceMonitor {
    public void monitorSystem(){
        System.out.println("Processors available" + SystemInfo.getProcessors() +
                "\nSystem average: " + SystemInfo.getSystemLoadAverage() +
                "\nCPU average: " + SystemInfo.getProcessCpuLoad() +
                "\nFree memory in bytes: " + SystemInfo.getFreeMemory() +
                "\nAllocated memory in bytes: " + SystemInfo.getMemoryUsageGB()
        );
    }
}
