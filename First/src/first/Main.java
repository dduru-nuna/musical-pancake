package first;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		double sum = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int max = arr[n-1];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]/max*100;
		}
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = sum / n;
		System.out.println(avg);
		br.close();
	}			         		
}
