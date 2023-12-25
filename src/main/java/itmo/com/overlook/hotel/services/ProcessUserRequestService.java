package itmo.com.overlook.hotel.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
    public class ProcessUserRequestService implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessUserRequestService.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("processing users request");
    }
}
