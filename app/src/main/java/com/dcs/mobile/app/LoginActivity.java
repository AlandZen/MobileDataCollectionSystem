package com.dcs.mobile.app;

import android.app.Activity;
//import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import com.dcs.mobile.utility.ActivityManager;
import com.dcs.mobile.utility.ExitApp;
import com.dcs.mobile.utility.ServiceManager;

/**
 * Created by Aland on 2014/6/5.
 */
public class LoginActivity extends Activity {

    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityManager.getAppManager().addActivity(this);
        setContentView(R.layout.activity_login);
    }

    public  void loginButtonClick(View v){
        //Toast.makeText(getApplicationContext(), "用户 Aland 登录成功", Toast.LENGTH_SHORT).show();

        //Intent data =new Intent();
        //data.putExtra("result",((EditText)this.findViewById(R.id.edtTxtAccount)).getText().toString().isEmpty());
        //setResult(12,data);

        //选中记住密码时，保存登录信息
        /*if (true){

        }*/

        Intent intent =new Intent();
        intent.putExtra("success",true);
        intent.putExtra("username",((EditText)this.findViewById(R.id.edtTxtAccount)).getText().toString());
        intent.setClass(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        //this.finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ExitApp.Exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
