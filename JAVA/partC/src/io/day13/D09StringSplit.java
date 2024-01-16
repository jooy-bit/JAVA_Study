package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit{
    private static String filePath = "score.txt";

    public static void main(String[] args) {
        List<Score> list =makeList();
        // System.out.println(list);   == System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i= "+i+", score object= "+list.get(i));
        }
        for (Score temp : list) {
            System.out.println(temp);       //list.get(i) 반복자로 실행 후 temp에 저장    
        }
    }


    public static Score makeScore(String line){
        String[] temp = line.split(",");
        Score score = new Score(temp[0].trim(), Integer.parseInt(temp[1].trim()), Integer.parseInt(temp[2].trim()), Integer.parseInt(temp[3].trim()));
        return score;
    }
    //1) Score.txt에서 모든 데이터를 읽어오고 2)Score 객체로 변환하여 3)리스트에 담고 4)리턴
    public static List<Score> makeList(){
        List<Score> scoreList = new ArrayList<>();
        String line;
        try (BufferedReader br =new BufferedReader(new FileReader(filePath))){
            while ((line=br.readLine())!=null) scoreList.add(makeScore(line));
        } catch (IOException e){System.out.println("파일 입력오류: "+e.getMessage());}
        return scoreList;
    }

    public static void split_test02(){
        String line;
        int count=0; 
        try (BufferedReader br =new BufferedReader(new FileReader(filePath))){
            while ((line=br.readLine())!=null) {
                Score stu = makeScore(line);
                System.out.println(String.format("COUNT= %d , SCORE OBJECT= %s", count,stu));
                count++;
            }            
        } catch (IOException e) {
            System.out.println("파일 입력오류: "+e.getMessage());
        }
        System.out.println("Score 객체: "+count+"개 생성 완료");
    }

    //split 메소드는 지정된 구분자(구분기호)를 이용해서 문자열을 분리하고 배열에 저장해서 리턴
    public static void split_test01(){
        String stu  ="김모모,67,77,88";
        String[] temp =stu.split(",");
        //System.out.println(Arrays.toString(temp));
        for (String t : temp) {
            System.out.println("배열 요소= "+t);
        }
        System.out.println("2. 분리된 결과로 Score 객체를 만들면 ?");
        //temp[0] = name temp[1]~[3]까지 정수 문자열 => 정수 변화
        Score score = new Score(temp[0], Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]));
        System.out.println("Score 출력1 :  " + score.datas());
        System.out.println("Score 출력2:  " + score);
    }
}