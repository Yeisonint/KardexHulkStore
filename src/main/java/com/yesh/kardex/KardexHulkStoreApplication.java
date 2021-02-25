package com.yesh.kardex;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KardexHulkStoreApplication {
	
	// Logger
	private static final Logger log = LoggerFactory.getLogger(KardexHulkStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KardexHulkStoreApplication.class, args);
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("No ha sido posible determinar la dirección del host, usando localhost en su lugar");
		}finally {
			log.info("Iniciando servidor en: http://"+hostAddress+":8080");
		}
	}

}
