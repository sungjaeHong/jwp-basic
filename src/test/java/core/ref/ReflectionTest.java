package core.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;

public class ReflectionTest {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
	Class<Question> clazz;
	
	@Before
	public void init(){
		clazz = Question.class;
	}
	@Test
	public void showClass() {
		Class<Question> clazz = Question.class;
		logger.debug(clazz.getName());

		

	}
	@Test
	public void showField(){
		Class<Question> clazz = Question.class;
		Field[] fieldList = clazz.getDeclaredFields();
		for(Field field:fieldList){
			logger.debug("Field Name : {}",field.getName());
		}
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void showConstructor(){
		
		Constructor[] constructorList = clazz.getConstructors();
		for(Constructor con : constructorList){
			Type[] paramType = con.getGenericParameterTypes();
			logger.debug("constructor : {}", con.getName());
			for(Type p : paramType){
				logger.debug("param:{}",p);
			}

		}
	}
	
	@Test
	public void showMethod(){
		Method[] methodList = clazz.getDeclaredMethods();
		for(Method method : methodList){
			logger.debug("method Name : {}",method.getName());
		}
	}
}
