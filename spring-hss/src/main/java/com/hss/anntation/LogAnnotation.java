package com.hss.anntation;

import java.lang.annotation.*;

/**
 * 自定义标签
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
public @interface LogAnnotation {
	String desc();
}

