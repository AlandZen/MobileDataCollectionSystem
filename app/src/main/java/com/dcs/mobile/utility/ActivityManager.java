package com.dcs.mobile.utility;

import java.util.Stack;
import android.app.Activity;
import android.content.Context;

public class ActivityManager {
	private static Stack<Activity> activityStack;
	private static ActivityManager instance;

	private ActivityManager() {

	}

	/**
	 * 获取ActivityManager单一实例
	 */
	public static ActivityManager getAppManager() {
		if (instance == null) {
			instance = new ActivityManager();
		}
		return instance;
	}

	/**
	 * 将activity添加到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获得当前activity(最后压入堆栈的activity)
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束当前的activity(最后压入堆栈的activity)
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 結束指定的activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 結束指定的activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 遍历结束所有的activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 结束所有的activity并且退出程序
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
