package caesar;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaesarCipher {

        char ciphertext[]; // 密文
        int key;
        char plaintext[]; // 明文
        StringBuffer plaintextStr = new StringBuffer("");
        StringBuffer ciphertextStr = new StringBuffer("");
        final int max = 500; // 最大字符

        public static void main(String[] args) {
            CaesarCipher m = new CaesarCipher();
            m.setKey();
            m.getPlaintext();
            m.encryption();
            m.deciphering();
            m.display();
        }

        /**
         * 设置密钥,返回偏移值
         * @return
         */
        int setKey() {
            System.out.println("***************** 欢迎使用凯撒加密器 *********************");
            System.out.println("请输入一个Caesar数字密钥：");
            while (true) {
                Scanner sc = new Scanner(System.in);
                try {
                    key = sc.nextInt() % 26; // %26的意义是获取密钥的偏移值
                    return key;
                } catch (Exception e) {
                    System.out.println("ERROR__请重新输入整数密钥...");
                }
            }
        }

        /**
         * 获得明文
         */
        void getPlaintext() {
            plaintext = new char[max];
            for (int j = 0; j < max; j++) {
                plaintext[j] = '★'; // 设置临时变量将数组填充，因明文中可存在' '空，所以需要填充判断
            }
            int i = 0;
            char ch = ' ';
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入明文");
            try {
                ch = (char) bf.read(); // 获得字符
                while (ch != '\r' && ch != '\n') { // 回车
                    plaintext[i] = ch;
                    i++;
                    try {
                        ch = (char) bf.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 加密
         */
        void encryption() {
            ciphertext = new char[max];
            for (int j = 0; j < max; j++) {
                ciphertext[j] = '★'; // 设置临时变量将数组填充，因明文中可存在' '空，所以需要填充判断
            }
            for (int i = 0; i < plaintext.length; i++) {
                if (plaintext[i] != '★') {
                    int temp = plaintext[i] + key;	// 偏移后的ASCII码
                    ciphertext[i]=(char)temp; // 加密符号
                    ciphertextStr.append(ciphertext[i]); // 拼接字符串
                } else {
                    break;
                }
            }
        }

        /**
         * 解密
         */
        void deciphering() {
            char c = ' ';
            for (int i = 0; i < ciphertext.length; i++) {
                if (ciphertext[i] != '★') {
                    int temp = ciphertext[i] - key;
                    c = (char) temp;
                    plaintextStr.append(c);		// 拼接解密字符串
                } else {
                    break;
                }
            }
        }

        /**
         * 显示对比结果
         */
        void display() {
            System.out.println("密文明文对比");
            System.out.println("密文：" + ciphertextStr);
            System.out.println("明文：" + plaintextStr);
        }



}