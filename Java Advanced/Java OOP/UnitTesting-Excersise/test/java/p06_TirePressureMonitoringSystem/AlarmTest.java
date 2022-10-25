package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.mockito.stubbing.OngoingStubbing;

import java.lang.ref.PhantomReference;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AlarmTest {

    private static final double NORMAL_PRESSURE = 20;
    private static final double LOW_PRESSURE = 5;
    private static final double HIGH_PRESSURE = 55;
    Sensor mockedSensor;
    Alarm alarm;

    @Before
    public void setup() {
        mockedSensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(mockedSensor);
    }

    @Test
    public void testAlarmIsOffNormalPressure() {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnLowPressure() {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnHighPressure() {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}