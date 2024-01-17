package io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.myapp.JavaWord;

public class D10FileWriter {

    public static void main(String[] args) {
        readByScanner2();    
    }
    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count=0;
      

        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bw.append("안녕하세요dydyd"+i+"\r\n");
                //append 기존 내용 뒤에 추가 //new FileWriter(filePath,true) 생성자에 설정필요
                //bw.writer("안녕하십니까?") //기존 파일 덮어쓰기
                count++;
            }
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }

    public static void writeByPrintWriter(){        
        String filePath = "단어장3.txt";
        int count=0;
        File file = new File(filePath);
        FileWriter fw = null;
        try( PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))){
            fw = new FileWriter(filePath,true);
            //PrintWriter 클래스 특징:
            //1)print,println 메소드 사용할 수 있음.
            //2)File 객체를 인자로 합니다

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                pw.print("안녕하세요"+i+"\r\n");       
                count++;
            }
            
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }

    public static void readByScanner(){
        String filePath = "단어장.txt";
        int count=0;
        //Scanner 클래스 : 1)한줄씩 읽어오는 nextLine()메소드, 2)구분기호로 분리해서 읽어오는 방법
        try( Scanner fc = new Scanner(new FileReader(filePath))){
                //
            fc.useDelimiter(",|\\n");

            // 파일의 끝까지 반복
            while (fc.hasNext()) {          //구분기호로 분리된 데이터가 있으면
                String token = fc.next();   //next 메소드로 가져오기
                System.out.println(token);
                count++;
            }

    } catch (Exception e) { }

        System.out.println("읽은 단어수 : "+count);
    }


    public static void readByScanner2(){
        String filePath = "단어장.txt";
        List<JavaWord> list = new ArrayList<>();
        int count=0;
        //Scanner 클래스 : 1)한줄씩 읽어오는 nextLine()메소드, 2)구분기호로 분리해서 읽어오는 방법
        try( Scanner fc = new Scanner(new FileReader(filePath))){
                //
            fc.useDelimiter(",|\\n");

            // 파일의 끝까지 반복
            while (fc.hasNext()) {      
                list.add(new JavaWord(fc.next()                                 //첫번째
                                    , fc.next()                                 //두번째
                                    , Integer.parseInt(fc.next().trim())));     //세번째
                String token = fc.next();   //next 메소드로 가져오기
                System.out.println(token);
                count++;
            }

    } catch (Exception e) { }
        System.out.println(list);
        System.out.println("읽은 단어수 : "+count);
        for (JavaWord word : list) System.out.println("생선된 개체: "+word);
    }

    
}