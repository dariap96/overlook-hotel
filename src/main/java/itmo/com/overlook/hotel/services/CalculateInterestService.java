package itmo.com.overlook.hotel.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculateInterestService implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateInterestService.class);


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("calculating interest of the loan");
    }
}
