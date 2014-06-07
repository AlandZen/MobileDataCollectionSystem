package com.dcs.mobile.utility;

import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by Aland on 2014/6/7.
 */
public class ExitApp {

    private static long mExitTime;

    public static void Exit(){
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(ActivityManager.getAppManager().currentActivity(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //android.os.Process.killProcess(android.os.Process.myPid());
            ActivityManager.getAppManager().finishAllActivity();
            System.exit(0);
        }
    }
}
