package frc.robot.sensors;

import java.util.Random;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RomiNullSensor extends SubsystemBase {
  private SimDouble m_nulSensorVal;
  private Random rand;
  
  /** Creates a new RomiNullSensor. */
  public RomiNullSensor() {
    SimDevice nullSensorDevice = SimDevice.create("NullSensor:RomiNullSensor");
    if (nullSensorDevice != null)
    {
      m_nulSensorVal = nullSensorDevice.createDouble("nulSensorVal", Direction.kInput, 123.0);
    }  
    rand = new Random();  
  }

   /**
   * Get the simulated sensor value.
   *
   * @return sensor value
   */
  public double getNullSensorVal() {
    if (m_nulSensorVal != null) {
      return m_nulSensorVal.get();
    }

    return -1.0;
  }    

  public void resetNullSensorVal() {
    if (m_nulSensorVal != null) {
      m_nulSensorVal.set(0.0);
    }
  }    

  public void setNullSensorVal(double inVal) {
    if (m_nulSensorVal != null) {
      m_nulSensorVal.set(inVal);
    }
  }    

  public void setNullSensorRandomVal() {
    if ((m_nulSensorVal != null) && (rand != null)) {
      m_nulSensorVal.set(rand.nextDouble());
    }
  }    

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setNullSensorVal(getNullSensorVal() + 1);
  }
}

