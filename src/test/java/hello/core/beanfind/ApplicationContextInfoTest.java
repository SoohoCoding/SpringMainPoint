package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);

        }
    }

    // 애플리케이션 빈 출력하기
    // 스프링 내부에서 사용하는 빈까지 모두 출력하고 싶지 않다면, 스프링이 내부에서 사용하는 빈을 걸러내는 방법이 필요하다.
    // 스프링은 내부에서 사용하는 빈의 이름을 스프링이 내부에서 정한 규칙에 따라 이름을 부여한다.
    // 스프링이 내부에서 사용하는 빈의 이름은 모두 특정 규칙을 가지고 있다. 따라서 이 규칙을 찾아내어 내부 빈을 걸러낼 수 있다.
        @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            if (bean.getClass().getPackage().getName().contains("hello.core")) {
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }

        }
    }
}
