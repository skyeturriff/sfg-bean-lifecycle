package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * There are a set of things/steps that happen as a Bean is being
 * initiated within the Spring Context as well as when the Bean is
 * being destroyed within the Spring Context.
 *
 * Implements the Spring Framework interfaces that allow us to work
 * with and hook into Lifecycle events.
 *
 * If we have a use case for hooking into or accessing the lifecycle
 * event of a Bean, these are the interfaces to implement.
 *
 * Most of the time, these hooks are used by Spring framework devs
 * and are not usually needed by Spring application devs.
 *
 * Also:
 * @see CustomBeanPostProcessor
 */
@Component
public class LifeCycleDemoBean implements

        InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleDemoBean Constructor!");
    }

    /**
     * From the {@link BeanNameAware} interface. This
     * method is one of the first to be called of the
     * "Aware" interfaces as the bean is being wired
     * up by the framework.
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("## LifeCycleDemoBean - Bean Name has been set! My Bean Name is: " + name);

    }

    /**
     * From the {@link BeanFactoryAware} interface. The
     * next of the "Aware" interfaces to be called by
     * the framework.
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## LifeCycleDemoBean - Bean Factory has been set!");
    }

    /**
     * From the {@link ApplicationContextAware} interface.
     * The third of the "Aware" interfaces to be called by
     * the framework.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## LifeCycleDemoBean - Application context has been set!");
    }

    /**
     * Not part of any implemented interface. This is a
     * post-process method that will be called by the
     * {@link CustomBeanPostProcessor} bean <i>before</i>
     * this bean's initialization methods.
     */
    public void beforeInit(){
        System.out.println("## LifeCycleDemoBean - Before Init - Called by CustomBeanPostProcessor!");
    }

    /**
     * The {@link PostConstruct} annotated method will
     * be called by the framework <i>after</i> the bean
     * has been constructed (so after dependency injection),
     * but before it is returned to the requesting object.
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("## LifeCycleDemoBean - @PostConstruct annotated method has been called!");
    }

    /**
     * From {@link InitializingBean} interface, which is
     * a callback interface. This method is called by the
     * framework <i>after</i> all the properties have been
     * set on the bean.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## LifeCycleDemoBean - My properties have been set!");

    }

    /**
     * Not part of any implemented interface. This is a
     * post-process method that will be called by the
     * {@link CustomBeanPostProcessor} bean <i>after</i>
     * this bean's initialization methods.
     */
    public void afterInit(){
        System.out.println("## LifeCycleDemoBean - After Init - Called by CustomBeanPostProcessor!");
    }

    /**
     * The {@link PreDestroy} annotated method will
     * be called by the framework just before the
     * bean is destroyed by the container.
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("## LifeCycleDemoBean - @PreDestroy annotated method has been called!");
    }

    /**
     * From the {@link DisposableBean} interface, which
     * is a callback interface. This method is called by
     * the framework during bean destruction.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("## LifeCycleDemoBean - I've been terminated!");

    }
}
