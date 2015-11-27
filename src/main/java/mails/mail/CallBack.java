package mails.mail;

import mails.annotations.TemplateCode;

/**
 * Created by Roma on 19 Oct 2015.
 */
@TemplateCode(3)
@TemplateCode(4)
public class CallBack implements MailGenerator {
    @Override
    public void sendMail() {
        System.out.println("Call back...");
    }
}
