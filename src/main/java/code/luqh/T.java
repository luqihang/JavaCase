package code.luqh;

import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author luqh
 * @date 2019/12/09
 **/
public class T {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        byte[] data = "helloworld".getBytes();
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKbpNPb1H2vZcXuAm7vTCwpyedEm8lOum2Kk6t91CPeHccow9+LzyKhtodbGKAoL/UawzaEynVbiXh4RptIOfkPoovl1RSUBagM0gq50YdfzncdAEWXSXA0TjlXbTPA0KPt48jRZfKJULJyPWiNWt5gb0EhID4RwQtssSY1S2H4vAgMBAAECgYA7x2pgyInoZohuYzFjo8Jgi391mS1RK0gbnFVCkvgTLz9h2wftEMLdD+bWtUHB12lu2APNqAMSCyEKQ+grc2Vk+K2dul3f1kmpLLUJQB3UgfxX/X2Iz93wrG3gCFjN1TVLvlJ6QRk0ooD5uEluzd1J/s6+XqcfKF/KwN7B0UlRAQJBANrZ+2r44kNh2G3tPbEEZxzAo/xjBJJyAvwpoba6hygRFhORVBQ+AhXuUlSJSj6Jnhw3WVVXjs5+oDwosABXETcCQQDDPjC7/iU0l53hTXqnXenyxoSIBvXITdnQj1JaDH87LQA6/i/OXlLPMkpNoMgWeiZdj4p2D8KB1+pPIVvWqNbJAkBXKtFX9w9v1S32ArM6qU1Eh3oJUYsFpUGJHC/b7wlcLQoE+zJo6ZW9FHJYV2Jp7Dg8dtMvCbPIjWjW7UHEsOkbAkAgwiqDIF01ucqvpsRRmJxMM6rA+An9FbLaH3H90eL3FtHXFBcJVSInyZRV+ggYXV5ajF76+CH2jzetFzfFiIahAkEAioiQL7ancrccQYL1SNpRzx/mZWyXieQexpj7nW1ORNoOwPtxWyD0pVQdLihwkAed1wURQg3sHIZmK18S8/O2jw==";
        byte[] e = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(e);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(privateK);
        signature.update(data);
        byte[] sign = signature.sign();

        System.out.println(new String(sign));

    }
}
