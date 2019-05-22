package com.hzy.openssl;

public class OpenSSLApi {

    static {
        System.loadLibrary("openssl");
    }

    public static native String getVersionString();

    public static native String encodeBase64(byte[] input);

    public static native String getMD5String(byte[] input);
}
