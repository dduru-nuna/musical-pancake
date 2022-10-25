package kr.co.exam02;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 회원 관리를 위한 프로그램을 만들기 위해 다음의 객체 정보가 필요하다.
		 *     Member : 모든 일반 회원은 해당 객체를 통해 다루어진다.
		 *              일반 회원은 게시글쓰기, 게시글보기, 게시글수정 작업만
		 *              할 수 있다.
		 *     Staff : 스태프 회원은 일반 회원들이 작성한 글을 삭제할 수 있는
		 *             작업을 가진다.
		 *     Admin : 관리자는 스태프 권한 제거 및 추가, 멤버 가입 및 탈퇴의
		 *             작업을 할 수 있다.
		 *             
		 * - 위 모든 객체는 이름, 나이 정보를 가지고 있다.
		 * - 위 관계를 파악하여 클래스의 상속, 오버로딩, 오버라이딩, 다형성을 적용하여
		 *   다루어 본다.
		 * - 실제 프로그램을 구현하는 것 아님.
		 * - 구현할 메서드는 단순 출력문이 동작하도록 한다.
		 */
		Member m = new Member();
		Member m1 = new Staff();
		Member m2 = new Admin();
		
		m.setName("박지수");
		m.setAge(22);
		
		m1.setName("김철수");
		m1.setAge(25);
		
		m2.setName("이지영");
		m2.setAge(32);
		
		System.out.println(m);
		System.out.println(m1);
		System.out.println(m2);
		
		Staff s1 = (Staff)m1;
		Admin a1 = (Admin)m2;
		
		s1.write();
		a1.addAccount();
		
		//Admin > Staff > Member 계층 상속 관계이면
		/*
		 *instanceof 연산자 사용해서 볼때 Admin 부터 순서대로 써야함
		 *
		 *for(int i=0; i < pArr.length; i++) {
		 *	 if(pArr[i] instanceof Admin) {
		 *       Admin a = (Admin)pArr[i];
		 *       a.addRole();
		 *       a.removeRole();
		 *   } else if(pArr[i] instanceof Staff) {
		 *      Staff s = (Staff)pArr[i];
		 *      s.delete();
		 *      .
		 *      .
		 *      .  이런식으로 admin부터    
		 */
	}

}
