
package walkingandroids;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static walkingandroids.FormatColors.ANSI_BG_RED;
import static walkingandroids.FormatColors.ANSI_RESET;
import static walkingandroids.FormatColors.ANSI_WHITE;

/**
 *
 * @author
 * @author
 * @author
 */
public class Sit {

    MovementCalculation mc = new MovementCalculation();
    private int milisecond = 1000;
    DecimalFormat df = new DecimalFormat("0.00");

    public int SitPosition1(Android android, String filePositions1, Battery battery, int counter) throws IOException {
        android.SetArticulations(filePositions1);
        mc.PositiveDegree(android);
        double extraUse = mc.CheckMaximumUsage(android);

        android.PrintInitialPosition();

        while ((battery.getActualVoltage() - extraUse) < 0) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.format("%-30s%1s", ANSI_WHITE + ANSI_BG_RED + "\n\nBATTERY IS LOW. RECHARGING..." + ANSI_RESET, "|\tSECOND " + counter);
            System.out.format("\nExtra use needed: " + df.format(extraUse) + "v");
            System.out.println("\nActual battery amount: " + df.format(battery.getActualVoltage()));
            if (extraUse >= battery.getActualVoltage()) {
                extraUse -= battery.getActualVoltage();
                battery.setActualVoltage(0);
            } else {
                battery.setActualVoltage(battery.getActualVoltage() - extraUse);
            }
            System.out.println("Battery left: " + df.format(battery.getActualVoltage() + battery.getHoldingMotors()) + "v");
            battery.setActualVoltage(battery.getActualVoltage() + battery.getRechargeAmount());
            counter++;

        }
        battery.setActualVoltage(battery.getActualVoltage() - extraUse);

        Map<String, Articulation> groupOne = new HashMap();

        groupOne.put("Left Ankle", android.getLeftAnkle());
        groupOne.put("Right Ankle", android.getRightAnkle());
        groupOne.put("Left Knee", android.getLeftKnee());
        groupOne.put("Right Knee", android.getRightKnee());
        groupOne.put("Left Hip", android.getLeftHip());
        groupOne.put("Right Hip", android.getRightHip());
        groupOne.put("Left Wrist", android.getLeftWrist());
        groupOne.put("Right Wrist", android.getRightWrist());
        groupOne.put("Left Elbow", android.getLeftElbow());
        groupOne.put("Right Elbow", android.getRightElbow());
        groupOne.put("Left Shoulder", android.getLeftShoulder());
        groupOne.put("Right Shoulder", android.getRightShoulder());
        groupOne.put("Head", android.getHead());

        while ((groupOne.get("Left Ankle").getMoveFlexion() != 0) || (groupOne.get("Right Ankle").getMoveFlexion() != 0)
                || (groupOne.get("Left Knee").getMoveFlexion() != 0) || (groupOne.get("Right Knee").getMoveFlexion() != 0)
                || (groupOne.get("Left Hip").getMoveFlexion() != 0) || (groupOne.get("Right Hip").getMoveFlexion() != 0)
                || (groupOne.get("Left Wrist").getMoveFlexion() != 0) || (groupOne.get("Right Wrist").getMoveFlexion() != 0)
                || (groupOne.get("Left Elbow").getMoveFlexion() != 0) || (groupOne.get("Right Elbow").getMoveFlexion() != 0)
                || (groupOne.get("Left Shoulder").getMoveRotation() != 0) || (groupOne.get("Right Shoulder").getMoveRotation() != 0)
                || (groupOne.get("Head").getMoveFlexion() != 0)) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.print("\n\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }

            System.out.format("%-30s%1s", "\nNOW SITTING...", "|\tSECOND " + counter);
            System.out.print("\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }
            mc.BalanceMovements(android, groupOne, battery);

            counter++;
        }

        return counter;
    }

    public int SitPosition2(Android android, String filePositions2, Battery battery, int counter) throws IOException {

        android.SetArticulations(filePositions2);
        mc.PositiveDegree(android);
        double extraUse = mc.CheckMaximumUsage(android);

        while ((battery.getActualVoltage() - extraUse) < 0) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.format("%-30s%1s", ANSI_WHITE + ANSI_BG_RED + "\n\nBATTERY IS LOW. RECHARGING..." + ANSI_RESET, "|\tSECOND " + counter);
            System.out.format("\nExtra use needed: " + df.format(extraUse) + "v");
            System.out.println("\nActual battery amount: " + df.format(battery.getActualVoltage()));
            if (extraUse >= battery.getActualVoltage()) {
                extraUse -= battery.getActualVoltage();
                battery.setActualVoltage(0);
            } else {
                battery.setActualVoltage(battery.getActualVoltage() - extraUse);
            }
            System.out.println("Battery left: " + df.format(battery.getActualVoltage() + battery.getHoldingMotors()) + "v");
            battery.setActualVoltage(battery.getActualVoltage() + battery.getRechargeAmount());
            counter++;

        }

        battery.setActualVoltage(battery.getActualVoltage() - extraUse);

        Map<String, Articulation> groupOne = new HashMap();
        groupOne.put("Left Ankle", android.getLeftAnkle());
        groupOne.put("Right Ankle", android.getRightAnkle());
        groupOne.put("Left Knee", android.getLeftKnee());
        groupOne.put("Right Knee", android.getRightKnee());
        groupOne.put("Left Hip", android.getLeftHip());
        groupOne.put("Right Hip", android.getRightHip());
        groupOne.put("Left Wrist", android.getLeftWrist());
        groupOne.put("Right Wrist", android.getRightWrist());
        groupOne.put("Left Elbow", android.getLeftElbow());
        groupOne.put("Right Elbow", android.getRightElbow());
        groupOne.put("Left Shoulder", android.getLeftShoulder());
        groupOne.put("Right Shoulder", android.getRightShoulder());

        while ((groupOne.get("Left Ankle").getMoveFlexion() != 0) || (groupOne.get("Right Ankle").getMoveFlexion() != 0)
                || (groupOne.get("Left Knee").getMoveFlexion() != 0) || (groupOne.get("Right Knee").getMoveFlexion() != 0)
                || (groupOne.get("Left Hip").getMoveFlexion() != 0) || (groupOne.get("Right Hip").getMoveFlexion() != 0)
                || (groupOne.get("Left Wrist").getMoveFlexion() != 0) || (groupOne.get("Right Wrist").getMoveFlexion() != 0)
                || (groupOne.get("Left Elbow").getMoveFlexion() != 0) || (groupOne.get("Right Elbow").getMoveFlexion() != 0)
                || (groupOne.get("Left Shoulder").getMoveRotation() != 0) || (groupOne.get("Right Shoulder").getMoveRotation() != 0)) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.print("\n\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }

            System.out.format("%-30s%1s", "\nNOW SITTING...", "|\tSECOND " + counter);
            System.out.print("\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }

            mc.BalanceMovements(android, groupOne, battery);

            counter++;
        }

        return counter;

    }

    public int SitPosition3(Android android, String filePositions3, Battery battery, int counter) throws IOException {

        android.SetArticulations(filePositions3);
        mc.PositiveDegree(android);
        double extraUse = mc.CheckMaximumUsage(android);

        while ((battery.getActualVoltage() - extraUse) < 0) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.format("%-30s%1s", ANSI_WHITE + ANSI_BG_RED + "\n\nBATTERY IS LOW. RECHARGING..." + ANSI_RESET, "|\tSECOND " + counter);
            System.out.format("\nExtra use needed: " + df.format(extraUse) + "v");
            System.out.println("\nActual battery amount: " + df.format(battery.getActualVoltage()) + "v");
            if (extraUse >= battery.getActualVoltage()) {
                extraUse -= battery.getActualVoltage();
                battery.setActualVoltage(0);
            } else {
                battery.setActualVoltage(battery.getActualVoltage() - extraUse);
            }
            System.out.println("Battery left: " + df.format(battery.getActualVoltage() + battery.getHoldingMotors()) + "v");
            battery.setActualVoltage(battery.getActualVoltage() + battery.getRechargeAmount());
            counter++;

        }

        battery.setActualVoltage(battery.getMaxVoltage() - extraUse - battery.getHoldingMotors());

        Map<String, Articulation> groupOne = new HashMap();
        groupOne.put("Left Elbow", android.getLeftElbow());
        groupOne.put("Right Elbow", android.getRightElbow());
        groupOne.put("Left Hip", android.getLeftHip());
        groupOne.put("Right Hip", android.getRightHip());
        groupOne.put("Left Shoulder", android.getLeftShoulder());
        groupOne.put("Right Shoulder", android.getRightShoulder());

        while ((groupOne.get("Left Elbow").getMoveFlexion() != 0) || (groupOne.get("Right Elbow").getMoveFlexion() != 0)
                || (groupOne.get("Left Hip").getMoveFlexion() != 0) || (groupOne.get("Right Hip").getMoveFlexion() != 0)
                || (groupOne.get("Left Shoulder").getMoveRotation() != 0) || (groupOne.get("Right Shoulder").getMoveRotation() != 0)) {
            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException ex) {
                Logger.getLogger(Android.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.print("\n\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }

            System.out.format("%-30s%1s", "\nNOW SITTING...", "|\tSECOND " + counter);
            System.out.print("\n");
            for (int i = 0; i < 173; i++) {
                System.out.print("=");
            }
            mc.BalanceMovements(android, groupOne, battery);

            counter++;
        }

        return counter;
    }

}
