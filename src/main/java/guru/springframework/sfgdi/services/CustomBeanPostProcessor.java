package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Implementing the {@link BeanPostProcessor} interface allows us
 * to do actions on Beans as they are processed before and after
 * initialization.
 *
 * These are hooks into the Spring Bean Lifecycle.
 *
 * This allows us to inspect ALL Spring Beans BEFORE they are
 * initialized, as well as AFTER they are initialized. This
 * allows us to hook into these events on more of a global scale,
 * if needed, for any special configuration needs.
 *
 * Most of the time, these hooks are used by Spring framework devs
 * and are not usually needed by Spring application devs.
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
     * This method is called by the framework <i>before</i>
     * each bean's initialization methods. In this override
     * we check for an instance of {@link LifeCycleDemoBean},
     * and if found, call a custom processing method.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof LifeCycleDemoBean){
            ((LifeCycleDemoBean) bean).beforeInit();
        }

        return bean;
    }

    /**
     * This method is called by the framework <i>after</i>
     * each bean's initialization methods. In this override
     * we check for an instance of {@link LifeCycleDemoBean},
     * and if found call a custom processing method.
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleDemoBean){
            ((LifeCycleDemoBean) bean).afterInit();
        }

        return bean;
    }
}
