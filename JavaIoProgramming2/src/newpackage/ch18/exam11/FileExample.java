
package ch18.exam11;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        
        //파일(디렉터리)의 정보얻기
        
        File file  = new File("src/ch18/exam11/FileExample.java");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isFile());
        
        File dir = new File("C:/Windows");
        System.out.println(dir.exists());
        System.out.println(dir.length());
        System.out.println(dir.isFile());
        
        //String[] contents1 = dir.list(); // 디렉터리 안에 파일 이름 리턴
        File[] contents2 = dir.listFiles(); //디렉터리 안에 파일의 객체를 리턴  -> 그 파일들의 속성들을 알려고 할때 별도로 객체를 만들필요없다.
        
        for(File f : contents2){
            String info = "";
            info+= f.getName();
            info+="\t\t";
            info += (f.isDirectory())?"<dir>":"";
            info+="\t\t";
            info+=  f.length();
            System.out.println(info);
        }
        
        
        
        //파일및 디렉터리의 생성과 삭제
        File file2 = new File("C:/Temp/test.txt");
        file2.createNewFile();
        file2.delete();//디렉터리에 내용이 있으면 지워지지 않는다. 
        
        File dir2 = new File("C:./Temp/dir2");
        dir2.mkdir();
        
         File dir3 = new File("C:./Temp/dir3/dir4/dir5");
        dir3.mkdirs(); //s가 붙으면 경로상 존재안하는 디렉터리는 모두 만들라는 코드.
    }
}
//파일의 정보를 알거나 삭제 생성은 가능하나, 내용을 수정못함. 이건 인풋아웃풋 스트림으로 한다.