package org.project;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationClass implements IAnnotationTransformer {

	public void transform(ITestAnnotation b, Class c, Constructor d, Method e) {
		IRetryAnalyzer analyzer = b.getRetryAnalyzer();
		if (analyzer == null) {
			b.setRetryAnalyzer(Retry.class);
			
		}
	}

}
