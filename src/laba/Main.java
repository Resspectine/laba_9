package laba;


import javax.crypto.*;
import java.io.*;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        Scanner consoleIn = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        File file = new File("C:\\Users\\maks6\\IdeaProjects\\laba_9\\input.txt");
        File filePasswords = new File("C:\\Users\\maks6\\IdeaProjects\\laba_9\\passwords.txt");
        RandomAccessFile fileRead = new RandomAccessFile(file, "rw");
        String buffer = fileRead.readLine();
        ArrayList<CarShop> cars = new ArrayList<>();
        while (buffer != null) {
            ArrayList<String> marks = new ArrayList<>();
            ArrayList<String> masters = new ArrayList<>();
            String[] elements1;
            String[] elements2;
            String[] elements3;
            elements1 = buffer.split("( \\| )+");
            elements2 = elements1[2].split("(, )+");
            elements3 = elements1[3].split("(, )+");
            for (int i = 0; i < elements2.length; i++) {
                marks.add(elements2[i]);
            }
            for (int i = 0; i < elements3.length; i++) {
                masters.add(elements3[i]);
            }
            cars.add(new CarShop(new BigDecimal(elements1[0]), Integer.valueOf(elements1[1]), marks, masters));
            buffer = fileRead.readLine();
        }
        Passwords pass = new Passwords(filePasswords);
        pass.codePasswords();
        System.out.println("Введите пароль:");
        String checkPassword = consoleIn.next();
        while (true) {
            if (!pass.checkPasswords(checkPassword)) {
                System.out.println("Wrong password. Try again:");
                checkPassword = consoleIn.next();
            } else
                break;
        }
            for (CarShop car : cars) {
                System.out.println(car);
            }
            oos.writeObject(cars);
            oos.flush();
            oos.close();
            System.out.println("Введите позицию:");
            int pos = consoleIn.nextInt();
            fileRead.seek(pos);
            String st = fileRead.readLine();
            SecretKey key;
            key = KeyGenerator.getInstance("DES").generateKey();
            DesEncrypter encrypter = new DesEncrypter(key);
            String sStr = encrypter.encrypt(st);
            String oStr2 = encrypter.decrypt(sStr);
            System.out.println(st);
            System.out.println(sStr);
    }
}