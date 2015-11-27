package mails.mail;

import mails.annotations.TemplateCode;

/**
 * Created by Roma on 19 Oct 2015.
 */
@TemplateCode(2)
public class HappyBirhday implements MailGenerator {
    @Override
    public void sendMail() {
        System.out.println("Happy birthday!");
    }
}
