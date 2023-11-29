package uz.devops.shukrullaev;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author Abdulloh
 * @see uz.devops.shukrullaev
 * @since 11/29/2023 7:13 PM
 */

@Service
public class Encrypt {
    public static String INSTANCE = "AES/CBC/PKCS5Padding";
    public final static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance(INSTANCE);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public byte[] encrypt(byte[] input, Key key, IvParameterSpec ivParameterSpec) {
        cipher.init(Cipher.ENCRYPT_MODE,
            key,
            ivParameterSpec);
        return cipher.doFinal(input);
    }

    @SneakyThrows
    public byte[] decrypt(byte[] encryptedInput, Key key, IvParameterSpec ivParameterSpec) {
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        return cipher.doFinal(encryptedInput);
    }
}
