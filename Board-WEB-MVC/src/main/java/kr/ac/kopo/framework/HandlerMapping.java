package kr.ac.kopo.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.framework.annotation.RequestMapping;

public class HandlerMapping {
	private Map<String , CtrlAndMethod> mappings;
	public HandlerMapping() throws Exception {
		mappings = new HashMap<>();
		// kr.ac.kopo.board.controller.BoardController
		
		Class<?> clz = Class.forName("kr.ac.kopo.board.controller.BoardController");
		Constructor<?> constructor = clz.getConstructor();
		// Object target = new BoardController();
		Object target = constructor.newInstance();
		
		Method[] methods = clz.getMethods();
//		Method[] methods = clz.getDeclaredMethods();
		for(Method method : methods) {
			
	//		System.out.println(method);
			RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
	//		System.out.println("reqAnno : " + reqAnno);
			if(reqAnno != null) {
				String uri = reqAnno.value();
				CtrlAndMethod cam = new CtrlAndMethod(target,method);
				mappings.put(uri, cam);
			}
		}
	}
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
	
}
