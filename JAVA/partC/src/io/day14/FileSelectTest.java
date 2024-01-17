package io.day14;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import java.awt.FileDialog;

public class FileSelectTest {
    public static void main(String[] args) {
        //GUI(Graphic User Interface)
        //Java.awt 와 Java.swing에서 제공
        showDialog();
    }
    public static Map<String,String> showDialog(){
        JFrame jf = new JFrame();
        jf.setSize(2000, 2000);
        jf.setVisible(false);
        FileDialog fd = new FileDialog(jf,"File Select",FileDialog.LOAD);
        fd.setVisible(true);
        //System.out.println("선택한 파일 폴더: "+ fd.getDirectory());
        //System.out.println("선택한 파일 : "+ fd.getFile());
        //System.out.println(fd.getDirectory().replace("\\", "\\\\")+fd.getFile().replace("\\", "\\\\"));
        Map<String,String>map = new HashMap<>();
        map.put("folder",fd.getDirectory().replace("\\", "\\\\"));
        map.put("fileName", fd.getFile().replace("\\", "\\\\"));
        //map.put("fileSize", fd.getHeight());
        return map;
    }

}
