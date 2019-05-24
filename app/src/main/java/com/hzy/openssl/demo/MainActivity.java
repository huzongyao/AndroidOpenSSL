package com.hzy.openssl.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hzy.openssl.OpenSSLApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.version_info)
    TextView mVersionInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getVersionInfo();
    }

    private void getVersionInfo() {
        mVersionInfo.setText(OpenSSLApi.getVersionString());
    }

    @OnClick(R.id.button_crypto_test)
    public void onButtonCryptoClicked() {
        startActivity(new Intent(this, CryptoTestActivity.class));
    }
}
