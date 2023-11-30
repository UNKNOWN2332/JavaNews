package uz.devops.shukrullaev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.devops.shukrullaev.test_package.TestClass;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.kerberos.EncryptionKey;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EncryptApplicationTest {
    @Autowired
    private TestClass testClass;
    @Autowired
    private Encrypt encrypt;

    @Test
    public void testEncrypt() throws IOException, NoSuchAlgorithmException {
        KeyGenerator keygenerator
            = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = keygenerator.generateKey();
        Class<?> c = testClass.getClass();
        String className = c.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        final byte[] classByte = Objects.requireNonNull(c.getClassLoader().getResourceAsStream(classAsPath)).readAllBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{12});
        System.out.println("classByte = " + new String(classByte));

        //Encrypt class before and print
        byte[] encrypt1 = encrypt.encrypt(classByte, myDesKey, ivParameterSpec);
        System.out.println("encrypt1 = " + new String(encrypt1));

        //Decrypt class after encrypt and print
        byte[] decrypt = encrypt.decrypt(encrypt1, myDesKey, ivParameterSpec);
        System.out.println("decrypt = " + new String(decrypt));
        for (int i = 0; i < decrypt.length; i++) {
            if(!(decrypt[i] == classByte[i])){
                System.out.println("error = ");
            }
        }


    }
}
