package hello;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.timo.model.Dog;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abraham Qin
 */
@RestController
public class GreetingController implements EnvironmentAware,ApplicationContextAware {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/hello")
	public String hello(){
    	return  "hello world";
	}

	/**
	 * spring boot 默认使用的json解析框架是jackson !
	 * @return
	 */
	@RequestMapping("/getDog")
	public Dog dog(){
		Dog dog = new Dog();
		dog.setAge(1034443);
		dog.setName("pug12oweoiooioi45667567678778888556666677777777");
		dog.setCreateTime(new Date());
		dog.setRemarks("备注");
		return  dog;
	}
	private Environment environment=null;
	private ApplicationContext applicationContext;
	@Override
	public void setEnvironment(Environment environment) {
		this.environment=environment;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}