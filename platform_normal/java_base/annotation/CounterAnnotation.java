package java_base.annotation;

import java.lang.annotation.Annotation;

public interface CounterAnnotation extends Annotation {

	int count();
}