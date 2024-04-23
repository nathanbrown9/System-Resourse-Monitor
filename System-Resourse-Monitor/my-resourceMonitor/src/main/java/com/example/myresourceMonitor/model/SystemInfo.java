// all import statements to access hardware information
package com.example.myresourceMonitor.model;
import org.springframework.stereotype.Component;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.net.*;
import java.util.*;



// the @component is to allow our springboot framework to allow java classes to work
// this is needed to work with out html page
@Component

// calling class system info to call on functions
public class SystemInfo {

    // creating instance of the operating system to access information
    // this 
    public static OperatingSystemMXBean osInfo = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    

    public static String getSystemLoadAverage() {
        double returned = osInfo.getSystemLoadAverage();
        String output = Double.toString(returned);
        return output;
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

    // correct
    public static String[] getMemory(){
        String[] returnMem = new String[2];
        returnMem[0] = getFreeMemory();
        returnMem[1] = getAllocatedMemory();
        return returnMem;
    }

    public static String getNetworkIncoming() throws SocketException {
        Enumeration<NetworkInterface> bandwidth = NetworkInterface.getNetworkInterfaces();
        NetworkInterface element = bandwidth.nextElement();
        return "" + element.getMTU();
    }
}
