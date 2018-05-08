package com.mkdika.springbootzktemplate.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ZKCEConfig.class) /*ZK CE config only*/
public @interface ZKCEApplication {    
}
