package object.day6;
public class AddQuiz {

/*     AddQuiz 클래스
+ data1: int -문제 데이터1
+ data2: int -문제 데이터2
+ userAnswer: int -학생 제출답
+ isRight() : boolean - 학생 제출 답이 정답이면 참을 리턴 */

//Class
private int data1;
private int data2;
private int userAnswer;
private boolean isRight;


//getter
    public int getData1() {
        return this.data1;
    }

    public int getData2() {
        return this.data2;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public boolean isRight(){
        return (getUserAnswer()==(getData1()+getData2())?)"O":"X";
    }

//setter
    public void setData1(int data1){
        this.data1=data1;
    }
    public void setData2(int data2){
        this.data2=data2;
    }
    public void setUserAnswer(int userAnswer){
        this.userAnswer=userAnswer;
    }
}