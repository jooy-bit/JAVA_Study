package object.day5;

public class Score {
    private String name;//name
    private int grade;  //grade
    private int[] jumsues;



//getter
    public String getName(){
    return name;
    }
    public int getGrade(){
    return grade;
    }
    public int[] getJumsues(){
    return jumsues;
    }
    //setter
    public void setName(String fN){
        name = fN;
    }
    public void setGrade(int fG){
        grade = fG;
    }
    public void setJumsues(int[] fS){
        jumsues = fS;
    }


//점수 합계 리턴
    public int sum(){
        int k=0;
        for (int i = 0; i < jumsues.length; i++) {
            k+=jumsues[i];
        }
        return k;
    }

//점수 평균 double 리턴 average() 메소드
    public double average(){
        return (double)sum()/jumsues.length;
        // double i =0;
        // if (grade>1) i =(double)sum()/5;
        // else i= (double)sum()/3;
        // return i;
    }   

//모든 인스턴스 필드값을 확인 출력하는 printScore() 메소드
    public void printScore(){
        System.out.println("========================================\n");
        System.out.println(String.format("이름 |\t%4s", name));
        System.out.println(String.format("학년 |\t%2d학년",grade));
        System.out.println(String.format("과목 | 평균 %5.2f점",average()));
        System.out.println(String.format("합계 | 총점 %d 점", sum()));
        System.out.println(String.format("과목수 | %d ", jumsues.length));

        System.out.println("========================================");
    }

}