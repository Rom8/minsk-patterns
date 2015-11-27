package mails;

import mails.annotations.TemplateCode;
import mails.mail.MailGenerator;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jeka on 26/09/2015.
 */
public class MailSender {

    private Map<Integer, MailGenerator> map;

    public MailSender() {
        map = new HashMap<>();
        Reflections reflections = new Reflections("mails.mail");
        Set<Class<? extends MailGenerator>> classes = reflections.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> clazz : classes) {
            TemplateCode[] templateCodes = clazz.getAnnotationsByType(TemplateCode.class);
            for (TemplateCode templateCode: templateCodes) {
                int code = templateCode.value();
                if (map.containsKey(code)) {
                    throw new RuntimeException(
                            String.format("More than one mail for one code: %s", code));
                }
                try {
                    map.put(code, clazz.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void sendMail() throws IllegalAccessException, InstantiationException {
        int code = DBUtils.getTemplateCode();
        if (map.containsKey(code)) {
            System.out.print(code + " ");
            map.get(code).sendMail();
        } else {
            System.out.println(code + " - no such code.");
        }
    }
}
