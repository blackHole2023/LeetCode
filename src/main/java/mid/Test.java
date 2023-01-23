package mid;

import java.io.FileInputStream;


/**
 * 读取16进制文件
 */
public class Test {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("E:\\Javastudy\\GitHub\\LeetCode\\target\\classes\\mid\\TestClass.class");
        int i = 0;
        int count = 0;
        while ((i=inputStream.read())!=-1){
            System.out.printf("%02X ", i);
            count++;
            if (count==16){
                System.out.println("");
                count = 0;
            }
        }
    }
}
