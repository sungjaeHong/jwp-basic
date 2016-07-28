package core.ref;

import java.lang.reflect.Method;

import org.hamcrest.core.StringStartsWith;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Junit3TestRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Junit3TestRunner.class);
	
	@Test
	public void run() throws Exception {
		Class<Junit3Test> clazz = Junit3Test.class;
		Object obj = clazz.newInstance();
		Method[] methodList = clazz.getDeclaredMethods();
		for(Method method : methodList){
			if(method.getName().startsWith("test")){
				method.invoke(obj);
			}
		}
		
	}
}
