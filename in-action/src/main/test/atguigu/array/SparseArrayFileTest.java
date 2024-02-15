package atguigu.array;

import java.awt.*;
import java.io.*;

/**
 * @author qikun
 * @date 2/14/2024  4:56 PM
 */
public class SparseArrayFileTest {
    public static void main(String[] args) throws IOException {
        // 1.新建一个二维数组
        int originArray[][] = new int[11][11];
        originArray[1][2] = 12;
        originArray[4][9] = 34;
        originArray[5][8] = 88;
        // 2.遍历数组
        System.out.println("原始数组");
        for(int[] row : originArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 3.遍历数组 非零个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        //4. 创建稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //5. 遍历原来的二维数组插入稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (originArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originArray[i][j];
                }
            }
        }
        System.out.println();
        // 6. 遍历稀疏数组
        File file = new File("D:\\data\\atguigu\\map.data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
        System.out.println();
        System.out.println("获得稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
            if (i == sparseArray.length - 1 ) {
                writer.append(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
            } else {
                writer.append(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2] + "\n");
            }
        }
        System.out.println("写入文件中");
        writer.close();
        fileOutputStream.close();

        // 读取文件中
        System.out.println("读取文件中");
        // Desktop.getDesktop().open(file);
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
        StringBuffer stringBuffer = new StringBuffer();
        while (reader.ready()) {
            stringBuffer.append((char) reader.read());
        }
        System.out.println("读取成功");
        System.out.println(stringBuffer.toString());
        reader.close();
        fileInputStream.close();
        // stringBuffer 转为稀疏数组
        String bufferString = stringBuffer.toString();
        String[] lines = bufferString.split("\n");
        int[][] fileSparse = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\t");
            fileSparse[i] = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                fileSparse[i][j] = Integer.parseInt(parts[j]);
            }
        }
        //字符转为数组成功
        System.out.println("字符转为数组成功");
        for(int[] row : fileSparse) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
