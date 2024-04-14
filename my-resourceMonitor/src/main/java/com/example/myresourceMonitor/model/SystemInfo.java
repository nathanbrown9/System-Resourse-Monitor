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

    public static long getFreeMemory() {
        return osInfo.getFreeMemorySize();
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
