package kr.ac.kopo.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import kr.ac.kopo.framework.annotation.RequestMapping;


public class CtrlAndMethod {
	private Object target;
	private Method method;
	
	
	public CtrlAndMethod(Object targe, Method method) {
		// TODO Auto-generated constructor stub
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	
	
	
	
}
