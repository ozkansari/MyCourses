package jee1;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * http://localhost:8088/OOP/jee1/index.xhtml
 * 
 */
@Named
@SessionScoped
public class HelloController implements Serializable {
	private static final long serialVersionUID = 3847171388850014203L;

	public String sayHello() {
		return "hello";
	}
}