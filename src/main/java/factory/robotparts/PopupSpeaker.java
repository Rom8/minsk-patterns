package factory.robotparts;

import javax.swing.*;

/**
 * Created by Jeka on 26/09/2015.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
