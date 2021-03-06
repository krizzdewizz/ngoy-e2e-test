package ngoy.e2e.app;

import ngoy.Ngoy.Builder;
import ngoy.core.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Provides all spring beans to ngoy.
 *
 * @author krizz
 * @see Builder#injectors(Injector...)
 */
@Service
public class BeanInjector implements Injector {

    @Autowired
    private ApplicationContext context;

    @Override
    public <T> T get(Class<T> clazz) {
        return context.getBeansOfType(clazz)
                .isEmpty() ? null : context.getBean(clazz);
    }

}