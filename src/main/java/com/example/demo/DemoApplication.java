package com.example.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.test.CarFactory;
import com.example.demo.test.CarFactory2;
import com.example.demo.test.JdbcTest;

@SpringBootApplication
public class DemoApplication {
	@Value("${url}")
	static String urlString;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		CarFactory car = (CarFactory) SpringUtil.getBean("car");
//		System.out.println(car.getId() + "---" + car.getName());
		CarFactory2 factory2 = new CarFactory2();
		boolean b = MyReflect.setObjByFieldAnno(factory2);
		if (b) {
			int calculate = factory2.calculate(5, 6);
			System.out.println(calculate);
		}else {
			 System.out.println("getObjByFieldAnno   不正确");
		}
		System.out.println(urlString);
	}

	@Bean(name = "car")
	private static CarFactory getCarFactory() {
		CarFactory car = new CarFactory();
		car.setId(1);
		car.setName("宝马");
		return car;
	}
	
	@Bean(name = "jdbctest",initMethod="test")
	private static JdbcTest getJdbcTest() {
		JdbcTest jdbcTest = new JdbcTest();
		return jdbcTest;
	}

}

class MyReflect {
	// 传入对象
	public static boolean setObjByFieldAnno(Object o) {
		// 获取Class
		Class c = o.getClass();
		/* 获得属性 */
		Field[] fields = c.getDeclaredFields();
		// 返回值用于判断是否完成这个方法
		boolean b = false;
		// 遍历域
		for (Field f : fields) {
			// 获取域中的注解，遍历注解
			Annotation[] anns = f.getAnnotations();
			for (Annotation ann : anns) {
				// 这里使用instanceof关键字，判断注解中是否包含MyAutowired
				if (ann instanceof MyAutowired) {
					System.out.println(f.getName() + "--这个属性使用了我的注解");
					// f.getGenericType()：获取该域的类型
					System.out.println(f.getGenericType().toString() + "--这个属性的类型");
					// 转成Class
					Class c2 = (Class) f.getGenericType();
					try {// 创建实例
						Object o2 = c2.newInstance();
						// 这个方法是将实例注入到这个域中，详细使用请查阅JAVA API
						f.setAccessible(true);
						f.set(o, o2);
						System.out.println("成功注入");
						// 成功则返回true
						b = true;
						return b;
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}

			}
		}
		return b;
	}
}