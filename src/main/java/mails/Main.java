package mails;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        final MailSender mailSender = new MailSender();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        mailSender.sendMail();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
