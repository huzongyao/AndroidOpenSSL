package com.hzy.openssl.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.hzy.openssl.OpenSSLApi;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.version_info)
    TextView mVersionInfo;
    @BindView(R.id.base64_openssl)
    TextView mBase64Openssl;
    @BindView(R.id.base64_java)
    TextView mBase64Java;
    @BindView(R.id.md5_java)
    TextView mMd5Java;
    @BindView(R.id.md5_openssl)
    TextView mMd5Openssl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getVersionInfo();
        runBase64Test();
        runMD5Test();
    }

    private void runMD5Test() {
        byte[] data = "hello OpenSSL!".getBytes();
        String javaString = "MD5(java):\n" + EncryptUtils.encryptMD5ToString(data);
        String sslString = "MD5(OpenSSL):\n" + OpenSSLApi.getMD5String(data);
        mMd5Java.setText(javaString);
        mMd5Openssl.setText(sslString);
    }

    private void runBase64Test() {
        byte[] data = "hello OpenSSL!".getBytes();
        String javaString = "Base64(java):\n" + EncodeUtils.base64Encode2String(data);
        String sslString = "Base64(OpenSSL):\n" + OpenSSLApi.encodeBase64(data);
        mBase64Java.setText(javaString);
        mBase64Openssl.setText(sslString);
    }

    private void getVersionInfo() {
        mVersionInfo.setText(OpenSSLApi.getVersionString());
    }
}
