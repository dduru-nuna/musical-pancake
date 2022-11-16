package kr.co.exam02;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	private int id;
	private int arr[];
	private int bonus;
	
	public Lotto(int id) {
		this.id = id;
		this.arr = new int[7];
	}
	
	public void generate() {
		Random rand = new Random();
		for(int i = 0; i < arr.length;) {
			int num = rand.nextInt(46) + 1;
			boolean duplicate = false;
			for(int j = 0; j < i; j++) {
				if(this.arr[j] == num) {
					duplicate = true;
					break;
				}
			}
			if(!duplicate) {
				this.arr[i] = num;
				i++;
		    }
		}
		this.bonus = this.arr[this.arr.length - 1];
		this.arr = Arrays.copyOf(this.arr, 6);
	}
	
	public String getLotto() {
		String str = "";
		for(int i = 0; i < this.arr.length; i++) {
			str += this.arr[i] + ", ";
		}
		return str + this.bonus;
	}
}
