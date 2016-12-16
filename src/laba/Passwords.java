package laba;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Passwords {
    private ArrayList<String> passwords;

    private SecretKey key;

    Passwords(File file) {
        try {
            passwords = new ArrayList<>();
            key = KeyGenerator.getInstance("DES").generateKey();
            DesEncrypter encrypter = new DesEncrypter(key);
            RandomAccessFile fileRead = new RandomAccessFile(file, "r");
            String buffer = fileRead.readLine();
            while (buffer != null) {
                passwords.add(encrypter.encrypt(buffer));
                buffer = fileRead.readLine();
            }
        } catch (Exception e) {
            System.out.println("Такого файла нет");
        }
    }

    public boolean checkPasswords(String str) {
        try {
            DesEncrypter encrypter = new DesEncrypter(key);
            for (String checkerString : passwords) {
                if (checkerString.equals(encrypter.encrypt(str))) {
                    return true;
                }
            }
        } catch (Exception e)
        {
            System.out.println("Такого файла нет");
        }
        return false;
    }

    public void codePasswords(File file) {
        try {
            FileWriter fstream1 = new FileWriter(file);
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            for (String checkerString :
                    passwords) {
                out1.append(checkerString);
                out1.newLine();
            }
            out1.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
