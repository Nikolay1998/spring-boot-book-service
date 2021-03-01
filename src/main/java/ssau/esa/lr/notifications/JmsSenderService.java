package ssau.esa.lr.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ssau.esa.lr.entity.Book;
import ssau.esa.lr.entity.Email;
import ssau.esa.lr.entity.Event;


@Service
public class JmsSenderService {

    private final JmsTemplate jmsTemplate;


    @Autowired
    public JmsSenderService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void sendBookCreate(Book book, String eventType){
        Email email = new Email();
        String addressee = "daniil_19n@mail.ru";
        email.setReceiver(addressee);
        email.setSubject("Book [" + eventType + ']');
        String bodyPattern = "Здравствуйте, %s !\n\n" +
                "Добавлена новая книга: %s Автора %s %s!";
        String body = String.format(bodyPattern,
                addressee, book.getName(), book.getAuthor().getName(), book.getAuthor().getSurname());
        email.setBody(body);
        jmsTemplate.convertAndSend("mailbox", email);
    }

    public <T> void sendEvent(Class<T> entityClass, T entity, String eventType){
        Event event = new Event();
        event.setEventType(eventType);
        event.setEntity(entity.toString());
        event.setEntityClass(entityClass.getSimpleName());
        jmsTemplate.convertAndSend("eventbox", event);
    }


}
