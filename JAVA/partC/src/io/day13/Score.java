package io.day13;

public class Score {
    public static void main(String[] args) {
        
    }

    private String name;
    private int korean;
    private int english;
    private int math;
    
    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    public String getName() {
        return name;
    }
    public int getEnglish() {
        return english;
    }
    
    public int getKorean() {
        return korean;
    }
    public int getMath() {
        return math;
    }
    public String datas() {
        return name + "," + korean + "," + english + "," + math;
    }
    @Override
    public String toString() {
        return "score [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }
    
    
}
