package ssau.esa.lr.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ssau.esa.lr.entity.Email;
import ssau.esa.lr.entity.Event;
import ssau.esa.lr.repos.EmailRepo;
import ssau.esa.lr.repos.EventRepo;


@Component
public class JmsReceiver {

    private final EmailSenderService emailSenderService;
    private final EventRepo eventRepo;
    private final EmailRepo emailRepo;

    @Autowired
    public JmsReceiver(EmailSenderService emailSenderService, EventRepo eventRepo, EmailRepo emailRepo) {
        this.emailSenderService = emailSenderService;
        this.eventRepo = eventRepo;
        this.emailRepo = emailRepo;
    }

    @JmsListener(destination = "eventbox", containerFactory = "myFactory")
    public void receiveEvent(Event event) {
        eventRepo.save(event);
    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        emailSenderService.send(email);
        emailRepo.save(email);
    }
}
