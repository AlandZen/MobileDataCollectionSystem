package com.dcs.mobile.utility;

import java.util.Stack;

import android.app.Service;

public class ServiceManager {
	private static Stack<Service> serviceStack;
	private static ServiceManager instance;

	public ServiceManager() {

	}

	/**
	 * 获取ServiceManager唯一实例
	 * 
	 * @return
	 */
	public static ServiceManager getServiceManager() {
		if (instance == null)
			return new ServiceManager();
		return null;
	}

	/**
	 * 将service添加到堆栈
	 */
	public void addService(Service service) {
		if (serviceStack == null) {
			serviceStack = new Stack<Service>();
		}
		serviceStack.add(service);
	}

	/**
	 * 获得当前service(最后压入堆栈的service)
	 */
	public Service currentserService() {
		Service service = serviceStack.lastElement();
		return service;
	}

	/**
	 * 结束当前的service(最后压入堆栈的activity)
	 */
	public void finishService() {
		Service service = serviceStack.lastElement();
		finishService(service);
	}

	/**
	 * 結束指定的service
	 */
	public void finishService(Service service) {
		if (service != null) {
			serviceStack.remove(service);
			service.stopSelf();
			service = null;
		}
	}

	/**
	 * 結束指定的service
	 */
	public void finishService(Class<?> clz) {
		for (Service service : serviceStack) {
			if (clz.equals(service.getClass()))
				finishService(service);
		}
	}

	/**
	 * 遍历结束所有的service
	 */
	public void finishAllService() {
		if (serviceStack != null) {
			for (int i = 0, size = serviceStack.size(); i < size; i++) {
				if (null != serviceStack.get(i)) {
					finishService(serviceStack.get(i));
				}
			}
			serviceStack.clear();
		}
	}
}
