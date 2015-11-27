package mails.mail;

import mails.annotations.TemplateCode;

/**
 * Created by Roma on 19 Oct 2015.
 */
@TemplateCode(1)
public class Greetings implements MailGenerator {
    @Override
    public void sendMail() {
        System.out.println("Greetings ");
    }
}
