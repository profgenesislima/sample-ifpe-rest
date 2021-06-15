package br.edu.ifpe.gus.ads4arq.testdrive;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ADS4ArqTestDrive {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123123"));

	}

}
