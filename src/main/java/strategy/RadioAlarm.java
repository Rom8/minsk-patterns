package strategy;

/**
 * Created by Jeka on 26/09/2015.
 */
public class RadioAlarm implements Radio, Alarm {
    private Alarm alarm;
    private Radio radio;

    public RadioAlarm(Alarm alarm, Radio radio) {
        this.alarm = alarm;
        this.radio = radio;
    }

    @Override
    public void a() {
        alarm.a();
    }

    @Override
    public void b() {
        alarm.a();
    }

    @Override
    public void c() {

        radio.c();
    }

    @Override
    public void d() {
        radio.d();
    }

}
