package polymorphism.ex;

public class BeanFactory {
	public Object getBean(String beanName) {
		
		if(beanName.equals("samsung")) {
			return new SamsungTVImpl();
		}else if(beanName.equals("lg")) {
			return new LgTVImpl();
		}
		
		return null;
	}
}
