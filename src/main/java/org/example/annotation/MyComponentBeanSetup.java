package org.example.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.context.support.GenericWebApplicationContext;
@Configuration
public class MyComponentBeanSetup {
  @Autowired
  private GenericWebApplicationContext applicationContext;

  @PostConstruct
  public void createBean()
      throws NoSuchMethodException {

    // Get all BeanDefinition
    ClassPathScanningCandidateComponentProvider provider =
        new ClassPathScanningCandidateComponentProvider(false);
    provider.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
    Set<BeanDefinition> beanDefs = provider
        .findCandidateComponents("org.example");

    for (BeanDefinition bd : beanDefs) {
      if (bd instanceof AnnotatedBeanDefinition) {
        Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
            .getMetadata()
            .getAnnotationAttributes(MyComponent.class.getCanonicalName());
        Class clazz = (Class) annotAttributeMap.get("clazz");
        Constructor c = clazz.getConstructor();
        applicationContext.registerBean(clazz, () -> {
          try {
            return c.newInstance();
          } catch (InstantiationException e) {
            throw new RuntimeException(e);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
          }
        });
      }
    }
    }

}
