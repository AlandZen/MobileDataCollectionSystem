package com.dcs.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Aland on 2014/6/5.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public  void loginButtonClick(View v){
        //Toast.makeText(getApplicationContext(), "用户 Aland 登录成功", Toast.LENGTH_SHORT).show();

        Intent data =new Intent();
        data.putExtra("result",((EditText)this.findViewById(R.id.edtTxtAccount)).getText());
        setResult(12,data);
        this.finish();
    }
}
