package de.starwit.example.beandemo;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


@Component
@Validated
public class SimpleComponent {
    
    private Logger log = LoggerFactory.getLogger(SimpleComponent.class); 

    @Autowired
    @Qualifier("sBean")
    SimpleBean sBean;
    
    @Autowired
    ConfiguredBean cBean;

    @Autowired
    @Qualifier("sBeanList")
    List<SimpleBean> beanList;

    @Autowired
    ScopedBean scopedBean;

    @PostConstruct
    public void doStuffOnStartup() {
        log.info("Bean constructed");
        sBean.doSomething();

        cBean.setEmail("nomail");
        cBean.setaNumber(11);
        cBean.setaStructuredString("");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ConfiguredBean>> violations = validator.validate(cBean);
        if (!violations.isEmpty()) {
            //throw new ConstraintViolationException(violations);
            for (ConstraintViolation<ConfiguredBean> violation : violations) {
                log.info(violation.getMessage());
            }
        }

        log.info("Size of beanList " + beanList.size());
        for (SimpleBean bean : beanList) {
            log.debug(bean.toString());
        }

        log.info("ScopedBean with value " + scopedBean.getNumber());
    }

    @PreDestroy
    public void cleanUp() {
        log.info("Component is about to be removed");
        beanList.clear();        
    }
}
