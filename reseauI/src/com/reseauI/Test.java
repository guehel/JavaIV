package com.reseauI;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Test {

	public static void main(String[] args) {
		try {
			InetAddress adresse = InetAddress.getByName("127.0.0.1");
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
