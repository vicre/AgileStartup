package com.datascilab.util.common;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

public class RsaTest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtils.getKeys();
        // 生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        RSAPublicKey publicKey2 = null;//new RSAPublicKey("");
        // 模
        String modulus = publicKey.getModulus().toString();
        // 公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        // 私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        // 明文
        String ming = "123456789";
        // 使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        // 加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println(publicKey.toString());
        System.err.println("密文：" + mi);
        // 解密后的明文
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println("解密后明文：" + ming);
    }
}
