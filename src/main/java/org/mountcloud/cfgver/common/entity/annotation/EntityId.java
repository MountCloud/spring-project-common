package org.mountcloud.cfgver.common.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * @author zhanghaishan
  * @version V1.0
  *
  * TODO: 类的id注解
  * 2020/1/16.
  */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EntityId {
	String value() default "";
}
