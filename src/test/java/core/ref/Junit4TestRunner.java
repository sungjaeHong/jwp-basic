package core.ref;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit4TestRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Junit4TestRunner.class);
	@Test
	public void run() throws Exception {
		Class<Junit4Test> clazz = Junit4Test.class;
		Object object = clazz.newInstance();
		Method[] method = clazz.getDeclaredMethods();
		
		for(Method m : method){
			if(m.isAnnotationPresent(MyTest.class)){
				m.invoke(object);
			}
		}
		
	}
}
