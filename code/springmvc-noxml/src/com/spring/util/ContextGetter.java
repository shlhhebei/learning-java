package com.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * �����࣬����������Ҫ��ȡApplicationContext����ʱ������ֱ�ӵ��ø���ľ�̬�������
 * 
 * ��web��Ŀ�У����뽫����ע�ᵽspring�����У�ʹApplicationContext����ע�뵽����ľ�̬������
 * @author win7
 *
 */
public class ContextGetter implements ApplicationContextAware {
	
	private static ApplicationContext xxx;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		xxx = arg0;	
	}
	
	public static Object getBean(String beanId){
		System.out.println(xxx.getDisplayName()+":"+xxx.getId()+":"+xxx.getStartupDate());
		return xxx.getBean(beanId);
	}
}