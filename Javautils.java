package Commonutils;

import java.util.Random;

public class Javautils {

	public int getRandomNumber() {
		
		Random r=new Random();
		int ran=r.nextInt(10);
		return ran;
	}

}
