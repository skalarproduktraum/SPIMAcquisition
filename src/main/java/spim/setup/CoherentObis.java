package spim.setup;

import mmcorej.CMMCore;
import org.micromanager.utils.ReportingUtils;
import spim.setup.SPIMSetup.SPIMDevice;

public class CoherentObis extends Laser {
    static {
        Device.installFactory(new Factory() {
            @Override
            public Device manufacture(CMMCore core, String label) {
                return new CoherentObis(core, label);
            }
        }, "CoherentObis", SPIMDevice.LASER1, SPIMDevice.LASER2);
    }

    public CoherentObis(CMMCore core, String label) {
        super(core, label);
    }

    @Override
    public void setPower(double power) { setProperty("PowerSetpoint", power * 1000); }

    @Override
    public double getPower() { return getPropertyDouble("PowerSetpoint") / 1000.0; }

    @Override
    public double getMinPower() {
        return getPropertyDouble("Minimum Laser Power");
    }

    @Override
    public double getMaxPower() {
        return getPropertyDouble("Maximum Laser Power");
    }

}
