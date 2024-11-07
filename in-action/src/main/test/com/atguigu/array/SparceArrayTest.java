package com.atguigu.array;

/**
 * @author qikun
 * @date 2/14/2024  8:35 AM
 */
public class SparceArrayTest {
    public static void main(String[] args) {
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
        System.out.println("获得稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }

        // 7. 稀疏数组转原始数组
        int[][] transArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            transArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 8. 遍历原始数组
        System.out.println("稀疏转为原始数组");
        for (int i = 0; i < sparseArray[0][0]; i++) {
            for (int j = 0; j < sparseArray[0][1]; j++) {
                System.out.printf("%d\t", transArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("遍历测试");
        int[][] aaray = new int[3][3];
        aaray[2][2] = 3;
        aaray[1][0] = 4;
        for (int[] row : aaray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
