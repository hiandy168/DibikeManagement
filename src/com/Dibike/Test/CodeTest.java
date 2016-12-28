package com.Dibike.Test;

import java.util.Random;

public class CodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		String code = "";
		for (int i = 0; i < 4; i++) {
			code += random.nextInt(10);
		}
		System.out.println(code);
	}

}
