package com.csu.petstorepro.petstore.common;

import com.csu.petstorepro.petstore.entity.Syslog;

import java.net.InetAddress;

public class GetIp {
     public String getIp() throws Exception
     {
        InetAddress addr = InetAddress.getLocalHost();
        return addr.getHostAddress();
     }
}
