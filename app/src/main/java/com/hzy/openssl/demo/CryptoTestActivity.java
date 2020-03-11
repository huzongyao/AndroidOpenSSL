package com.hzy.openssl.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.hzy.openssl.OpenSSLApi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoTestActivity extends AppCompatActivity {

    @BindView(R.id.base64_openssl)
    TextView mBase64Openssl;
    @BindView(R.id.base64_java)
    TextView mBase64Java;
    @BindView(R.id.md5_java)
    TextView mMd5Java;
    @BindView(R.id.md5_openssl)
    TextView mMd5Openssl;
    @BindView(R.id.sha1_java)
    TextView mSha1Java;
    @BindView(R.id.sha1_openssl)
    TextView mSha1Openssl;

    private byte[] mTestData = "Hello OpenSSL!".getBytes();
    private ExecutorService mThreadPool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_test);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mThreadPool = Executors.newSingleThreadExecutor();
        mThreadPool.submit(this::runSHA1Test);
        mThreadPool.submit(this::runMD5Test);
        mThreadPool.submit(this::runBase64Test);
    }

    private void runSHA1Test() {
        String javaString = "SHA1(java):\n" + EncryptUtils.encryptSHA1ToString(mTestData);
        String sslString = "SHA1(OpenSSL):\n" + OpenSSLApi.getSHA1String(mTestData);
        runOnUiThread(() -> {
            mSha1Java.setText(javaString);
            mSha1Openssl.setText(sslString);
        });
    }

    private void runMD5Test() {
        String javaString = "MD5(java):\n" + EncryptUtils.encryptMD5ToString(mTestData);
        String sslString = "MD5(OpenSSL):\n" + OpenSSLApi.getMD5String(mTestData);
        runOnUiThread(() -> {
            mMd5Java.setText(javaString);
            mMd5Openssl.setText(sslString);
        });
    }

    private void runBase64Test() {
        String javaString = "Base64(java):\n" + EncodeUtils.base64Encode2String(mTestData);
        String sslString = "Base64(OpenSSL):\n" + OpenSSLApi.encodeBase64(mTestData);
        runOnUiThread(() -> {
            mBase64Java.setText(javaString);
            mBase64Openssl.setText(sslString);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        mThreadPool.shutdown();
        super.onDestroy();
    }
}
