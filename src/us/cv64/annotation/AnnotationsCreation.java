// https://www.youtube.com/watch?v=rWlHQnvrZcw
package java18w.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// create an Annotation, e.g. SmartPhone which is a java.lang.annotation.Annotation
// 0 values - marker annotation
// 1 value - single value annotation
// 2 or more values - multi-value annotation // SmartPhone has 2 or more values, e.g. OS and version
// @Target and @Retention - Meta annotations

@Inherited  // allow other Classes to inherit the annotation
@Documented // provided in documentation
@Target(ElementType.TYPE) // TYPE = Class Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
	String os() default "Android";
	int version() default 0;
}

// using the Annotation
@SmartPhone(os = "Android", version = 6)
class ASeries {
	
	String model;
	int size;
	
	public ASeries(String model, int size) {
		super();
		this.model = model;
		this.size = size;
	}
}

public class AnnotationsCreation {

	public static void main(String[] args) {
		ASeries object = new ASeries("Fire", 5);
		
		Class clss = object.getClass();
		Annotation annotation = clss.getAnnotation(SmartPhone.class);
		SmartPhone smartPhone = (SmartPhone)annotation;
		System.out.println(smartPhone.os());
	}
}
