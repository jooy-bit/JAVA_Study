package object.day8;


public class AnimalCommunity {

	public static void main(String[] args)  {
			System.out.println("~~~~~~~~~여기는 유기동물 입양소 입니다~~~~~~~~~~");
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("푸들이","브라운");
			animals[1] = new Cat("그레이");
			animals[2] = new Rabbit();
			animals[2].setColor("화이트");
			animals[3] = new Puppy("말티즈","화이트");
			//퀴즈 : 아래 객체를 배열 요소에 대입했습니다. 수정이 필요한 코드는?
			animals[7] = new Animal() {
				static final String TYPE ="새";
				@Override
				public void sound(){
					System.out.println("");
				}

				@Override
				public String toString(){
					return TYPE+"[color= "+color+", name="+name+"]";
				}
			};
			animals[7].setColor("빨강");
			animals[7].setName("앵무새");
			System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
				if(animals[i]!= null)			//배열요소에 참조되는 객체가 있는지
					animals[i].sound();
			}	
			
	//	모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	//	동물 보호소 규정
	//	강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그 이외는 20세 이상 분양받을 수 있습니다.			
	//			Member클래스 isAdopt 메소드에서 실행 --> instanceof 연산 사용	
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);		//Member 클래스 인스턴스 필드는 age, name
		
		StringBuilder sb = new StringBuilder(name);	//String 문자열 연결과 다른 문자열이 나오면 객체 새로만들어 저장
		//String은 불변객체, StringBuilder 가변객체 가변가능
		sb.append(" 회원님 \n");				//message += "회원님 \n";
		boolean result;
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) 
				//break;	
				continue;			// 참조값이 없으면 break;
			//  result =member.isAdopt(animals[i]);	//문자열 애니멀로 받는 메소드
			 sb.append(animals[i].toString());
			// if(member.isAdopt(animals[i])//resu;t
			// ) {
			// 	sb.append("  😃 분양 가능합니다. \n");
			// } else {
			// 	sb.append("  😓 분양 자격이 안됩니다.\n");
			// }//아래 삼항연산자를 대신 이용 가능~~
			String temp = member.isAdopt(animals[i])?"분양 가능합니다\n":"분양 불가합니다\n";
			sb.append(temp);
		}
		System.out.println();
		System.out.println(sb);
		System.out.println(sb.toString()); //StringBuilder 타입 객체는 println의 인자로 쓸 때, toString 명시적 실행, 생략가능

	}//main end
	
}







