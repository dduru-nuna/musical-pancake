package kr.co.demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 컬렉션
		 *    - 자바에서 제공하는 자료구조를 담당하는 프레임워크
		 *    - 배열에 데이터를 담아 관리하는 방법에서 자료구조를 적용하여 좀 더 효율적으로
		 *      데이터를 관리할 수 있도록 다양한 기능 제공
		 *    - 구현된 자료구조 종류에 따라 List, Set, Map 등으로 분류하여 제공  
		 *      
		 * 배열 VS 컬렉션
		 *    배열 특징
		 *       - 한 번 크기를 정하면 변경할 수 없다.
		 *       - 배열에 저장된 데이터의 추가/수정/삭제 과정이 불편하다.
		 *       - 한 가지 타입에 대해서만 저장할 수 있다. (다형성 사용하면 여러타입 저장 가능)
		 *       
		 *    컬렉션 특징
		 *       - 언제든 크기를 늘리거나 줄일 수 있다.
		 *       - 컬렉션에 저장된 데이터의 추가/수정/삭제 등의 과정은 기본 제공하는 메서드로 처리 가능
		 *       - 여러 타입에 대한 데이터 저장이 가능하다.
		 */
		
		/* 
		 * List 계열 컬렉션   ( 배열과 거의 유사 )
		 *       - 데이터를 순차적으로 나열한 자료구조로 되어 있으며, 인덱스로 관리를 한다.
		 *       - 중복 데이터 저장 가능
		 *       - 구현 클래스로는 ArrayList, Vector, LinkedList 가 있다.
		 *       
		 * ArrayList
		 *       - List 의 구현체로 초기 저장 용량 10 에서 데이터가 추가/삭제 될 때마다
		 *         자동으로 늘어나면서 데이터를 관리한다.
		 *       - Thread Safe 기능을 제공하지 않는다.
		 *       
		 * Vector
		 *       - ArrayList 와 동일하며, Thread Safe 기능을 제공한다.
		 *       
		 * LinkedList
		 *       - 특정 위치에 데이터를 추가하거나 제거를 하면 앞/뒤 노드의 링크 정보만 변경하는
		 *         형태로 동작하며 이로 인해 빈번한 데이터의 추가/수정에 가장 우수한 성능을 가짐
		 */
		
		// 제네릭 타입 <> : 객체에서 사용할 일반 객체 타입을 지정하기 위해 쓰임
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		// 데이터 추가
		aList.add(Integer.valueOf(10)); aList.add(Integer.valueOf(20));
		aList.add(Integer.valueOf(30)); aList.add(Integer.valueOf(40));
		System.out.println(aList);
		
		// 원하는 위치에 데이터 추가
		aList.add(2, Integer.valueOf(25));
		System.out.println(aList);
		
		// 원하는 위치의 데이터 수정
		aList.set(4, 45);
		System.out.println(aList);
		
		// 원하는 위치의 데이터 삭제
		aList.remove(3);
		System.out.println(aList);
		
		// 데이터 찾아서 삭제
		aList.remove(Integer.valueOf(25));
		System.out.println(aList);
		
		// 데이터 추출
		Integer i = aList.get(1);
		System.out.println(i);
		
		// 데이터 확인
		boolean isExists = aList.contains(Integer.valueOf(45));
		System.out.println(isExists);
		
		// 데이터 확인 후 위치 알아내기
		int index = aList.indexOf(Integer.valueOf(45));
		System.out.println("index : " + index);
		
		// 저장된 데이터 수 확인
		int size = aList.size();
		System.out.println(size + "개의 데이터가 저장되어 있습니다.");
		
		// 다른 리스트 계열 컬렉션에 저장된 데이터를 추가
		ArrayList<Integer> bList = new ArrayList<Integer>();
		bList.add(140); bList.add(120); bList.add(130);
		bList.add(110); bList.add(160); bList.add(150);
		
		// bList에 저장된 데이터가 aList로 복사
		aList.addAll(bList);
		System.out.println(aList);
		
		// 전부 삭제
		bList.clear();
		System.out.println(bList);
		
		// 리스트 컬렉션이 비어 있는지 확인
		boolean isEmpty = aList.isEmpty();
		System.out.println(isEmpty);
		isEmpty = bList.isEmpty();
		System.out.println(isEmpty);
		
		// 전체 탐색
		for(int n = 0; n < aList.size(); n++) {
			System.out.print(aList.get(n) + "\t");
		}
		System.out.println();
		
		// foreach 를 사용한 전체 탐색
		// foreach 문은 간단하나 반복문을 통한 탐색처럼 일괄 작업이 불가하다. 필요에 따라 적절히 사용하기
		for(Integer n: aList) {
			System.out.print(n + "\t");
		}
		System.out.println();
		
		// 리스트 일부만 잘라서 새로 만들기
		ArrayList<Integer> subList = new ArrayList<Integer>(aList.subList(3, 7));
		System.out.println(subList);
		System.out.println(aList);  // 기존 aList가 없어지는게 아니라 일부 복사해서 새로 만드는 것
		
		// 리스트를 Object 배열로 반환
		Object[] objArr = aList.toArray();
		for(int n = 0; n < objArr.length; n++) {
			Integer num = (Integer)objArr[n];
			System.out.print(num + "\t");
		}
		System.out.println();
		
		// 리스트에 저장된 객체 타입에 맞추어 배열로 반환
		Integer[] iArr = aList.toArray(new Integer[aList.size()]);
		for(int n = 0; n < objArr.length; n++) {
			System.out.print(iArr[n] + "\t");
		}
		System.out.println();
		
		// 정렬 - reverse (역순)
		Collections.reverse(aList);
		System.out.println(aList);
		
		// 정렬 - sort (오름차순)
		Collections.sort(aList);
		System.out.println(aList);
		
		// 정렬 - sort (내림차순) : sort 후 reverse
		Collections.sort(aList);
		Collections.reverse(aList);
		System.out.println(aList);
		
		// 사용자 정의 객체를 리스트에 사용
		ArrayList<Subject> sList = new ArrayList<Subject>();
		sList.add(new Subject("국어", 78.2));
		sList.add(new Subject("영어", 69.4));
		sList.add(new Subject("수학", 87.5));
		sList.add(new Subject("과학", 91.7));
		
		System.out.println(sList);
		
		// 컬렉션 sort 기능 이용하려면 Comparable 인터페이스 상속 필요
		Collections.sort(sList);
		System.out.println(sList);
		
		// 리스트 계열의 컬렉션들이기 때문에 동일한 기능 지원
		// 내부 동작은 다르다
		List<Integer> cList = new ArrayList<Integer>();
		cList = new Vector<Integer>();
		cList = new LinkedList<Integer>();
	}

}
