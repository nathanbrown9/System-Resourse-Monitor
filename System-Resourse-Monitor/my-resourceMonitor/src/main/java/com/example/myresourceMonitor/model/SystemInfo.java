package com.example.myresourceMonitor.model;
import org.springframework.stereotype.Component;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.text.DecimalFormat;

@Component
public class SystemInfo {

    private static OperatingSystemMXBean osInfo = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static int getProcessors() {
        return osInfo.getAvailableProcessors();
    }

    public static double getSystemLoadAverage() {
        return osInfo.getSystemLoadAverage();
    }

    public static double getProcessCpuLoad() {
        return osInfo.getCpuLoad();
    }

    public static String getFreeMemory() {
        long freemem = osInfo.getFreeMemorySize();
        String str = Long.toString(freemem);
        return str;
    }

    public static String getAllocatedMemory(){
        long allocmem = osInfo.getCommittedVirtualMemorySize();
        String str = Long.toString(allocmem);
        return str;
    }

    public static String[] getMemory(){
        String[] returnMem = new String[2];
        returnMem[0] = getFreeMemory();
        returnMem[1] = getAllocatedMemory();
        return returnMem;
    }

    public static String getMemoryUsageGB() {
        long totalMemoryBytes = osInfo.getTotalMemorySize();
        long freeMemoryBytes = osInfo.getFreeMemorySize();
        long usedMemoryBytes = totalMemoryBytes - freeMemoryBytes;
        double usedMemoryGB = (double) usedMemoryBytes / (1024 * 1024 * 1024);
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(usedMemoryGB);
    }
}
