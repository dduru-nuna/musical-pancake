package kr.co.exam01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exam {

	public static ArrayList<Integer> getLottoNumber() {
		ArrayList<Integer> lottoNumber = new ArrayList<Integer>();
		Random rand = new Random();
		
		while(lottoNumber.size() < 6) {
			Integer num = Integer.valueOf(rand.nextInt(45) + 1);
			if(!lottoNumber.contains(num)) {
				lottoNumber.add(num);
			}
		}
		
		Collections.sort(lottoNumber);
		return lottoNumber;
	}
	
	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 *     - 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 *     - 중복된 번호 없이 리스트에 담기도록 한다.
		 *     - 총 6개의 번호가 리스트에 저장되야 한다.
		 *     - 마지막에 출력 할 때는 오름차순으로 정렬하여 출력되도록 한다.
		 */
		
		/*
		 * 위에서 생성한 로또 번호 6개를 한 세트라고 하자.
		 * 
		 * 1. 사용자가 원하는 수의 세트로 로또 번호가 생성되어 파일에 저장 될 수 있도록 한다.
		 * 2. 저장할 때 D:\\lotto.txt 파일로 저장되도록 한다.
		 * 3. 한 줄에 한 세트의 로또 번호가 출력되어야 한다.
		 * 4. 번호를 출력할 때 쉼표(,) 를 구분자로 하여 출력되도록 해야 한다.
		 */
		File f = new File("D:\\lotto.txt");
		
		int count = 10;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
			for(int i =0; i < count; i++) {
				ArrayList<Integer> lots = getLottoNumber();
				// 대괄호 없애고 출력
				bw.write(lots.toString().substring(1, lots.toString().length() - 1));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
/*		내가 푼거
 * 		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		Random rand = new Random();
		aList.add(rand.nextInt(45) + 1); aList.add(rand.nextInt(45) + 1);
		aList.add(rand.nextInt(45) + 1); aList.add(rand.nextInt(45) + 1);
		aList.add(rand.nextInt(45) + 1); aList.add(rand.nextInt(45) + 1);
		boolean dup = false;
		for(int i = 0; i < aList.size(); i++) {	
			for(int j = 0; j < i; j++) {
				if(aList.get(j) == aList.get(i)) {
					dup = true;
					aList.remove(j);
					aList.add(rand.nextInt(45) + 1);
					break;
				}
			}

		}
		Collections.sort(aList);
		System.out.println(aList);
		*/
	}

	

}
