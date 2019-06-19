package walkingandroids;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author fabriciobarros
 * @author aldanalouzan
 */
public class MovementCalculation {

    private double availableBattery = 0;

    private double degreePerSecondLeftShoulderFlexion = 0;
    private double degreePerSecondLeftShoulderRotation = 0;
    private double degreePerSecondRightShoulderFlexion = 0;
    private double degreePerSecondRightShoulderRotation = 0;
    private double degreePerSecondHeadFlexion = 0;
    private double degreePerSecondHeadRotation = 0;
    private double degreePerSecondWaistFlexion = 0;
    private double degreePerSecondWaistRotation = 0;
    private double totalDegreePerSecondLeftAnkle = 0;
    private double totalDegreePerSecondRightAnkle = 0;
    private double totalDegreePerSecondLeftKnee = 0;
    private double totalDegreePerSecondRightKnee = 0;
    private double totalDegreePerSecondLeftHip = 0;
    private double totalDegreePerSecondRightHip = 0;
    private double totalDegreePerSecondLeftWrist = 0;
    private double totalDegreePerSecondRightWrist = 0;
    private double totalDegreePerSecondLeftElbow = 0;
    private double totalDegreePerSecondRightElbow = 0;
    private double totalDegreePerSecondLeftShoulder = 0;
    private double totalDegreePerSecondRightShoulder = 0;
    private double totalDegreePerSecondHead = 0;
    private double totalDegreePerSecondNeck = 0;
    private double totalDegreePerSecondWaist = 0;
    private double grandTotalDegreesPerSecond = 0;
    private double totalVoltsLeftAnkle = 0;
    private double totalVoltsRightAnkle = 0;
    private double totalVoltsLeftKnee = 0;
    private double totalVoltsRightKnee = 0;
    private double totalVoltsLeftHip = 0;
    private double totalVoltsRightHip = 0;
    private double totalVoltsLeftWrist = 0;
    private double totalVoltsRightWrist = 0;
    private double totalVoltsLeftElbow = 0;
    private double totalVoltsRightElbow = 0;
    private double totalVoltsLeftShoulder = 0;
    private double totalVoltsRightShoulder = 0;
    private double totalVoltsHead = 0;
    private double totalVoltsNeck = 0;
    private double totalVoltsWaist = 0;
    private double grandTotalVolts = 0;
    private double totalMovementAvailablePerSecond = 0;
    private double proportionPerSecond = 0;
    private double degreesToMoveLeftShoulderFlexion = 0;
    private double degreesToMoveLeftShoulderRotation = 0;
    private double degreesToMoveRightShoulderFlexion = 0;
    private double degreesToMoveRightShoulderRotation = 0;
    private double degreesToMoveHeadFlexion = 0;
    private double degreesToMoveHeadRotation = 0;
    private double degreesToMoveWaistFlexion = 0;
    private double degreesToMoveWaistRotation = 0;
    private double finalDegreesToMoveLeftAnkle = 0;
    private double finalDegreesToMoveRightAnkle = 0;
    private double finalDegreesToMoveLeftKnee = 0;
    private double finalDegreesToMoveRightKnee = 0;
    private double finalDegreesToMoveLeftHip = 0;
    private double finalDegreesToMoveRightHip = 0;
    private double finalDegreesToMoveLeftWrist = 0;
    private double finalDegreesToMoveRightWrist = 0;
    private double finalDegreesToMoveLeftElbow = 0;
    private double finalDegreesToMoveRightElbow = 0;
    private double finalDegreesToMoveLeftShoulder = 0;
    private double finalDegreesToMoveRightShoulder = 0;
    private double finalDegreesToMoveHead = 0;
    private double finalDegreesToMoveNeck = 0;
    private double finalDegreesToMoveWaist = 0;
    private double finalVoltsUsedLeftAnkle = 0;
    private double finalVoltsUsedRightAnkle = 0;
    private double finalVoltsUsedLeftKnee = 0;
    private double finalVoltsUsedRightKnee = 0;
    private double finalVoltsUsedLeftHip = 0;
    private double finalVoltsUsedRightHip = 0;
    private double finalVoltsUsedLeftWrist = 0;
    private double finalVoltsUsedRightWrist = 0;
    private double finalVoltsUsedLeftElbow = 0;
    private double finalVoltsUsedRightElbow = 0;
    private double finalVoltsUsedLeftShoulder = 0;
    private double finalVoltsUsedRightShoulder = 0;
    private double finalVoltsUsedHead = 0;
    private double finalVoltsUsedNeck = 0;
    private double finalVoltsUsedWaist = 0;
    private double finalTotalVoltsUsed = 0;
    private int counter = 0;
    private int milisecond = 1000;

    DecimalFormat df = new DecimalFormat("0.00");

    public MovementCalculation() {
    }

    public void BalanceMovements(Android android, Map<String, Articulation> group, Battery battery) {
        availableBattery = battery.getActualVoltage();
        ArrayList<Articulation> previousPosition = this.PreviousPosition(group);
        Map<String, Articulation> initialPosition = new HashMap<>();

        for (int i = 0; i < previousPosition.size(); i++) {

            Articulation tempArt = new Articulation();
            tempArt = previousPosition.get(i);

            initialPosition.put(tempArt.getName(), tempArt);
        }

        if (group.containsKey("Left Ankle")) {
            totalDegreePerSecondLeftAnkle = CheckTotalDegreesPerSecondFlexion(group.get("Left Ankle"));
            totalVoltsLeftAnkle = CalcTotalVolts(group.get("Left Ankle"), totalDegreePerSecondLeftAnkle);
        } else {
            totalDegreePerSecondLeftAnkle = 0.0;
            totalVoltsLeftAnkle = 0.0;

        }

        if (group.containsKey("Right Ankle")) {
            totalDegreePerSecondRightAnkle = CheckTotalDegreesPerSecondFlexion(group.get("Right Ankle"));
            totalVoltsRightAnkle = CalcTotalVolts(group.get("Right Ankle"), totalDegreePerSecondRightAnkle);
        } else {
            totalDegreePerSecondRightAnkle = 0.0;
            totalVoltsRightAnkle = 0.0;

        }

        if (group.containsKey("Left Knee")) {
            totalDegreePerSecondLeftKnee = CheckTotalDegreesPerSecondFlexion(group.get("Left Knee"));
            totalVoltsLeftKnee = CalcTotalVolts(group.get("Left Knee"), totalDegreePerSecondLeftKnee);
        } else {
            totalDegreePerSecondLeftKnee = 0.0;
            totalVoltsLeftKnee = 0.0;

        }

        if (group.containsKey("Right Knee")) {
            totalDegreePerSecondRightKnee = CheckTotalDegreesPerSecondFlexion(group.get("Right Knee"));
            totalVoltsRightKnee = CalcTotalVolts(group.get("Right Knee"), totalDegreePerSecondRightKnee);
        } else {
            totalDegreePerSecondRightKnee = 0.0;
            totalVoltsRightKnee = 0.0;

        }

        if (group.containsKey("Left Hip")) {
            totalDegreePerSecondLeftHip = CheckTotalDegreesPerSecondFlexion(group.get("Left Hip"));
            totalVoltsLeftHip = CalcTotalVolts(group.get("Left Hip"), totalDegreePerSecondLeftHip);
        } else {
            totalDegreePerSecondLeftHip = 0.0;
            totalVoltsLeftHip = 0.0;

        }

        if (group.containsKey("Right Hip")) {
            totalDegreePerSecondRightHip = CheckTotalDegreesPerSecondFlexion(group.get("Right Hip"));
            totalVoltsRightHip = CalcTotalVolts(group.get("Right Hip"), totalDegreePerSecondRightHip);
        } else {
            totalDegreePerSecondRightHip = 0.0;
            totalVoltsRightHip = 0.0;

        }

        if (group.containsKey("Left Wrist")) {
            totalDegreePerSecondLeftWrist = CheckTotalDegreesPerSecondFlexion(group.get("Left Wrist"));
            totalVoltsLeftWrist = CalcTotalVolts(group.get("Left Wrist"), totalDegreePerSecondLeftWrist);
        } else {
            totalDegreePerSecondLeftWrist = 0.0;
            totalVoltsLeftWrist = 0.0;

        }

        if (group.containsKey("Right Wrist")) {
            totalDegreePerSecondRightWrist = CheckTotalDegreesPerSecondFlexion(group.get("Right Wrist"));
            totalVoltsRightWrist = CalcTotalVolts(group.get("Right Wrist"), totalDegreePerSecondRightWrist);
        } else {
            totalDegreePerSecondRightWrist = 0.0;
            totalVoltsRightWrist = 0.0;

        }

        if (group.containsKey("Left Elbow")) {
            totalDegreePerSecondLeftElbow = CheckTotalDegreesPerSecondFlexion(group.get("Left Elbow"));
            totalVoltsLeftElbow = CalcTotalVolts(group.get("Left Elbow"), totalDegreePerSecondLeftElbow);
        } else {
            totalDegreePerSecondLeftElbow = 0.0;
            totalVoltsLeftElbow = 0.0;

        }
        if (group.containsKey("Right Elbow")) {
            totalDegreePerSecondRightElbow = CheckTotalDegreesPerSecondFlexion(group.get("Right Elbow"));
            totalVoltsRightElbow = CalcTotalVolts(group.get("Right Elbow"), totalDegreePerSecondRightElbow);
        } else {
            totalDegreePerSecondRightElbow = 0.0;
            totalVoltsRightElbow = 0.0;

        }

        if (group.containsKey("Left Shoulder")) {
            degreePerSecondLeftShoulderFlexion = CheckTotalDegreesPerSecondFlexion(group.get("Left Shoulder"));
            degreePerSecondLeftShoulderRotation = CheckTotalDegreesPerSecondRotation(group.get("Left Shoulder"));
            totalDegreePerSecondLeftShoulder = degreePerSecondLeftShoulderFlexion + degreePerSecondLeftShoulderRotation;
            totalVoltsLeftShoulder = CalcTotalVolts(group.get("Left Shoulder"), totalDegreePerSecondLeftShoulder);
        } else {
            totalDegreePerSecondLeftShoulder = 0.0;
            totalVoltsLeftShoulder = 0.0;

        }
        if (group.containsKey("Right Shoulder")) {
            degreePerSecondRightShoulderFlexion = CheckTotalDegreesPerSecondFlexion(group.get("Right Shoulder"));
            degreePerSecondRightShoulderRotation = CheckTotalDegreesPerSecondRotation(group.get("Right Shoulder"));
            totalDegreePerSecondRightShoulder = degreePerSecondRightShoulderFlexion + degreePerSecondRightShoulderRotation;
            totalVoltsRightShoulder = CalcTotalVolts(group.get("Right Shoulder"), totalDegreePerSecondRightShoulder);
        } else {
            totalDegreePerSecondRightShoulder = 0.0;
            totalVoltsRightShoulder = 0.0;

        }
        if (group.containsKey("Head")) {
            degreePerSecondHeadFlexion = CheckTotalDegreesPerSecondFlexion(group.get("Head"));
            degreePerSecondHeadRotation = CheckTotalDegreesPerSecondRotation(group.get("Head"));
            totalDegreePerSecondHead = degreePerSecondHeadFlexion + degreePerSecondHeadRotation;
            totalVoltsHead = CalcTotalVolts(group.get("Head"), totalDegreePerSecondHead);
        } else {
            totalDegreePerSecondHead = 0.0;
            totalVoltsHead = 0.0;

        }

        if (group.containsKey("Neck")) {
            totalDegreePerSecondNeck = CheckTotalDegreesPerSecondFlexion(group.get("Neck"));
            totalVoltsNeck = CalcTotalVolts(group.get("Neck"), totalDegreePerSecondNeck);
        } else {
            totalDegreePerSecondNeck = 0.0;
            totalVoltsNeck = 0.0;

        }
        if (group.containsKey("Waist")) {
            degreePerSecondWaistFlexion = CheckTotalDegreesPerSecondFlexion(group.get("Waist"));
            degreePerSecondWaistRotation = CheckTotalDegreesPerSecondRotation(group.get("Waist"));
            totalDegreePerSecondWaist = degreePerSecondWaistFlexion + degreePerSecondWaistRotation;
            totalVoltsWaist = CalcTotalVolts(group.get("Waist"), totalDegreePerSecondWaist);
        } else {
            totalDegreePerSecondWaist = 0.0;
            totalVoltsWaist = 0.0;

        }

        grandTotalDegreesPerSecond = totalDegreePerSecondLeftAnkle + totalDegreePerSecondRightAnkle
                + totalDegreePerSecondLeftElbow + totalDegreePerSecondRightElbow
                + totalDegreePerSecondLeftHip + totalDegreePerSecondRightHip
                + totalDegreePerSecondLeftKnee + totalDegreePerSecondRightKnee
                + totalDegreePerSecondLeftShoulder + totalDegreePerSecondRightShoulder
                + totalDegreePerSecondLeftWrist + totalDegreePerSecondRightWrist
                + totalDegreePerSecondHead + totalDegreePerSecondNeck + totalDegreePerSecondWaist;

        grandTotalVolts = totalVoltsLeftAnkle + totalVoltsRightAnkle
                + totalVoltsLeftElbow + totalVoltsRightElbow
                + totalVoltsLeftHip + totalVoltsRightHip
                + totalVoltsLeftKnee + totalVoltsRightKnee
                + totalVoltsLeftShoulder + totalVoltsRightShoulder
                + totalVoltsLeftWrist + totalVoltsRightWrist
                + totalVoltsHead + totalVoltsNeck + totalVoltsWaist;

        totalMovementAvailablePerSecond = (availableBattery * grandTotalDegreesPerSecond) / grandTotalVolts;

        proportionPerSecond = CalcBatteryProportion(availableBattery, grandTotalVolts, totalMovementAvailablePerSecond, grandTotalDegreesPerSecond);

        if (group.containsKey("Left Ankle")) {
            finalDegreesToMoveLeftAnkle = totalDegreePerSecondLeftAnkle * proportionPerSecond;
            finalVoltsUsedLeftAnkle = finalDegreesToMoveLeftAnkle * group.get("Left Ankle").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Ankle"), finalDegreesToMoveLeftAnkle);

        } else {
            finalDegreesToMoveLeftAnkle = 0.0;
            finalVoltsUsedLeftAnkle = 0.0;

        }
        if (group.containsKey("Right Ankle")) {
            finalDegreesToMoveRightAnkle = totalDegreePerSecondRightAnkle * proportionPerSecond;
            finalVoltsUsedRightAnkle = finalDegreesToMoveRightAnkle * group.get("Right Ankle").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Ankle"), finalDegreesToMoveRightAnkle);

        } else {
            finalDegreesToMoveRightAnkle = 0.0;
            finalVoltsUsedRightAnkle = 0.0;

        }

        if (group.containsKey("Left Elbow")) {
            finalDegreesToMoveLeftElbow = totalDegreePerSecondLeftElbow * proportionPerSecond;
            finalVoltsUsedLeftElbow = finalDegreesToMoveLeftElbow * group.get("Left Elbow").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Elbow"), finalDegreesToMoveLeftElbow);

        } else {
            finalDegreesToMoveLeftElbow = 0.0;
            finalVoltsUsedLeftElbow = 0.0;

        }

        if (group.containsKey("Right Elbow")) {
            finalDegreesToMoveRightElbow = totalDegreePerSecondRightElbow * proportionPerSecond;
            finalVoltsUsedRightElbow = finalDegreesToMoveRightElbow * group.get("Right Elbow").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Elbow"), finalDegreesToMoveRightElbow);

        } else {
            finalDegreesToMoveRightElbow = 0.0;
            finalVoltsUsedRightElbow = 0.0;

        }

        if (group.containsKey("Head")) {
            degreesToMoveHeadFlexion = degreePerSecondHeadFlexion * proportionPerSecond;
            degreesToMoveHeadRotation = degreePerSecondHeadRotation * proportionPerSecond;
            finalDegreesToMoveHead = degreesToMoveHeadFlexion + degreesToMoveHeadRotation;
            finalVoltsUsedHead = finalDegreesToMoveHead * group.get("Head").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Head"), degreesToMoveHeadFlexion);
            android.SetMovementRotation(group.get("Head"), degreesToMoveHeadRotation);

        } else {
            finalDegreesToMoveHead = 0.0;
            finalVoltsUsedHead = 0.0;

        }

        if (group.containsKey("Left Hip")) {
            finalDegreesToMoveLeftHip = totalDegreePerSecondLeftHip * proportionPerSecond;
            finalVoltsUsedLeftHip = finalDegreesToMoveLeftHip * group.get("Left Hip").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Hip"), finalDegreesToMoveLeftHip);

        } else {
            finalDegreesToMoveLeftHip = 0.0;
            finalVoltsUsedLeftHip = 0.0;

        }
        if (group.containsKey("Right Hip")) {
            finalDegreesToMoveRightHip = totalDegreePerSecondRightHip * proportionPerSecond;
            finalVoltsUsedRightHip = finalDegreesToMoveRightHip * group.get("Right Hip").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Hip"), finalDegreesToMoveRightHip);

        } else {
            finalDegreesToMoveRightHip = 0.0;
            finalVoltsUsedRightHip = 0.0;

        }
        if (group.containsKey("Left Knee")) {
            finalDegreesToMoveLeftKnee = totalDegreePerSecondLeftKnee * proportionPerSecond;
            finalVoltsUsedLeftKnee = finalDegreesToMoveLeftKnee * group.get("Left Knee").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Knee"), finalDegreesToMoveLeftKnee);

        } else {
            finalDegreesToMoveLeftKnee = 0.0;
            finalVoltsUsedLeftKnee = 0.0;

        }
        if (group.containsKey("Right Knee")) {
            finalDegreesToMoveRightKnee = totalDegreePerSecondRightKnee * proportionPerSecond;
            finalVoltsUsedRightKnee = finalDegreesToMoveRightKnee * group.get("Right Knee").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Knee"), finalDegreesToMoveRightKnee);

        } else {
            finalDegreesToMoveRightKnee = 0.0;
            finalVoltsUsedRightKnee = 0.0;

        }

        if (group.containsKey("Neck")) {
            finalDegreesToMoveNeck = totalDegreePerSecondNeck * proportionPerSecond;
            finalVoltsUsedNeck = finalDegreesToMoveNeck * group.get("Neck").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Neck"), finalDegreesToMoveNeck);

        } else {
            finalDegreesToMoveNeck = 0.0;
            finalVoltsUsedNeck = 0.0;

        }

        if (group.containsKey("Left Shoulder")) {
            degreesToMoveLeftShoulderFlexion = degreePerSecondLeftShoulderFlexion * proportionPerSecond;
            degreesToMoveLeftShoulderRotation = degreePerSecondLeftShoulderRotation * proportionPerSecond;
            finalDegreesToMoveLeftShoulder = degreesToMoveLeftShoulderFlexion + degreesToMoveLeftShoulderRotation;
            finalVoltsUsedLeftShoulder = finalDegreesToMoveLeftShoulder * group.get("Left Shoulder").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Shoulder"), degreesToMoveLeftShoulderFlexion);
            android.SetMovementRotation(group.get("Left Shoulder"), degreesToMoveLeftShoulderRotation);

        } else {
            finalDegreesToMoveLeftAnkle = 0.0;
            finalVoltsUsedLeftShoulder = 0.0;

        }
        if (group.containsKey("Right Shoulder")) {
            degreesToMoveRightShoulderFlexion = degreePerSecondRightShoulderFlexion * proportionPerSecond;
            degreesToMoveRightShoulderRotation = degreePerSecondRightShoulderRotation * proportionPerSecond;
            finalDegreesToMoveRightShoulder = degreesToMoveRightShoulderFlexion + degreesToMoveRightShoulderRotation;
            finalVoltsUsedRightShoulder = finalDegreesToMoveRightShoulder * group.get("Right Shoulder").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Shoulder"), degreesToMoveRightShoulderFlexion);
            android.SetMovementRotation(group.get("Right Shoulder"), degreesToMoveRightShoulderRotation);

        } else {
            finalDegreesToMoveRightShoulder = 0.0;
            finalVoltsUsedRightShoulder = 0.0;

        }

        if (group.containsKey("Waist")) {
            degreesToMoveWaistFlexion = degreePerSecondWaistFlexion * proportionPerSecond;
            degreesToMoveWaistRotation = degreePerSecondWaistRotation * proportionPerSecond;
            finalDegreesToMoveWaist = degreesToMoveWaistFlexion + degreesToMoveWaistRotation;
            finalVoltsUsedWaist = finalDegreesToMoveWaist * group.get("Waist").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Waist"), degreesToMoveWaistFlexion);
            android.SetMovementRotation(group.get("Waist"), degreesToMoveWaistRotation);

        } else {
            finalDegreesToMoveWaist = 0.0;
            finalVoltsUsedWaist = 0.0;

        }
        if (group.containsKey("Left Wrist")) {
            finalDegreesToMoveLeftWrist = totalDegreePerSecondLeftWrist * proportionPerSecond;
            finalVoltsUsedLeftWrist = finalDegreesToMoveLeftWrist * group.get("Left Wrist").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Left Wrist"), finalDegreesToMoveLeftWrist);

        } else {
            finalDegreesToMoveLeftWrist = 0.0;
            finalVoltsUsedLeftWrist = 0.0;

        }
        if (group.containsKey("Right Wrist")) {
            finalDegreesToMoveRightWrist = totalDegreePerSecondRightWrist * proportionPerSecond;
            finalVoltsUsedRightWrist = finalDegreesToMoveRightWrist * group.get("Right Wrist").getVoltsPerDegree();
            android.SetMovementFlexion(group.get("Right Wrist"), finalDegreesToMoveRightWrist);

        } else {
            finalDegreesToMoveRightWrist = 0.0;
            finalVoltsUsedRightWrist = 0.0;

        }

        finalTotalVoltsUsed = finalVoltsUsedLeftAnkle + finalVoltsUsedRightAnkle
                + finalVoltsUsedLeftElbow + finalVoltsUsedRightElbow
                + finalVoltsUsedLeftHip + finalVoltsUsedRightHip
                + finalVoltsUsedLeftKnee + finalVoltsUsedRightKnee
                + finalVoltsUsedLeftShoulder + finalVoltsUsedRightShoulder
                + finalVoltsUsedLeftWrist + finalVoltsUsedRightWrist
                + finalVoltsUsedHead + finalVoltsUsedNeck + finalVoltsUsedWaist;

        System.out.format("%-31s%-30s%-30s%-30s%-1s", "\n\nARTICULATION MOVING", "|\tDEGREES LEFT(Flexion)", "|\tDEGREES LEFT(Rotation)", "|\tDEGREES LEFT AFTER MOVEMENT(Flexion)", "|\tDEGREES LEFT AFTER MOVEMENT(Rotation)");
        System.out.print("\n");
        for (int i = 0; i < 173; i++) {
            System.out.print("-");
        }

        Iterator entriesG = group.entrySet().iterator();

        while (entriesG.hasNext()) {
            Map.Entry entryG = (Map.Entry) entriesG.next();
            Articulation valueG = (Articulation) entryG.getValue();
            Articulation tempArt = valueG;

            System.out.format("%-30s%-30s%-30s%-38s%-1s", "\n" + tempArt.getName(), "|\t"
                    + df.format(initialPosition.get(tempArt.getName()).getMoveFlexion()), "|\t" + df.format(initialPosition.get(tempArt.getName()).getMoveRotation()), "|\t"
                    + df.format(tempArt.getMoveFlexion()), "|\t" + df.format(tempArt.getMoveRotation()));
        }

        System.out.print("\n");
        for (int i = 0; i < 173; i++) {
            System.out.print("-");
        }
        System.out.format("%-31s%-30s%1s", "\n\nPREVIOUS BATTERY AMOUNT", "|\tVOLTS USED", "|\tBATTERY LEFT");
        System.out.format("%-30s%-30s%1s", "\n" + df.format(battery.getActualVoltage()) + "v", "|\t" + df.format(finalTotalVoltsUsed) + "v", "|\t" + df.format((battery.getActualVoltage() - finalTotalVoltsUsed) + battery.getHoldingMotors()) + "v");
        battery.setActualVoltage(battery.getActualVoltage() - finalTotalVoltsUsed);
        System.out.println("\n\nRECHARGING...");
        battery.setActualVoltage(battery.getActualVoltage() + battery.getRechargeAmount());
        System.out.println("BATTERY AFTER RECHARGE: " + df.format((battery.getActualVoltage() + battery.getHoldingMotors())) + "v");

    }

    public void PositiveDegree(Android android) {

        if (android.getLeftAnkle().getMoveFlexion() < 0) {
            android.getLeftAnkle().setMoveFlexion(android.getLeftAnkle().getMoveFlexion() * -1);
        }

        if (android.getRightAnkle().getMoveFlexion() < 0) {
            android.getRightAnkle().setMoveFlexion(android.getRightAnkle().getMoveFlexion() * -1);
        }

        if (android.getLeftKnee().getMoveFlexion() < 0) {
            android.getLeftKnee().setMoveFlexion(android.getLeftKnee().getMoveFlexion() * -1);
        }

        if (android.getRightKnee().getMoveFlexion() < 0) {
            android.getRightKnee().setMoveFlexion(android.getRightKnee().getMoveFlexion() * -1);
        }

        if (android.getLeftHip().getMoveFlexion() < 0) {
            android.getLeftHip().setMoveFlexion(android.getLeftHip().getMoveFlexion() * -1);
        }

        if (android.getRightHip().getMoveFlexion() < 0) {
            android.getRightHip().setMoveFlexion(android.getRightHip().getMoveFlexion() * -1);
        }

        if (android.getWaist().getMoveFlexion() < 0) {
            android.getWaist().setMoveFlexion(android.getWaist().getMoveFlexion() * -1);
        }

        if (android.getWaist().getMoveRotation() < 0) {
            android.getWaist().setMoveRotation(android.getWaist().getMoveRotation() * -1);
        }

        if (android.getLeftWrist().getMoveFlexion() < 0) {
            android.getLeftWrist().setMoveFlexion(android.getLeftWrist().getMoveFlexion() * -1);
        }

        if (android.getRightWrist().getMoveFlexion() < 0) {
            android.getRightWrist().setMoveFlexion(android.getRightWrist().getMoveFlexion() * -1);
        }

        if (android.getLeftElbow().getMoveFlexion() < 0) {
            android.getLeftElbow().setMoveFlexion(android.getLeftElbow().getMoveFlexion() * -1);
        }

        if (android.getRightElbow().getMoveFlexion() < 0) {
            android.getRightElbow().setMoveFlexion(android.getRightElbow().getMoveFlexion() * -1);
        }

        if (android.getLeftShoulder().getMoveFlexion() < 0) {
            android.getLeftShoulder().setMoveFlexion(android.getLeftShoulder().getMoveFlexion() * -1);
        }

        if (android.getLeftShoulder().getMoveRotation() < 0) {
            android.getLeftShoulder().setMoveRotation(android.getLeftShoulder().getMoveRotation() * -1);
        }

        if (android.getRightShoulder().getMoveFlexion() < 0) {
            android.getRightShoulder().setMoveFlexion(android.getRightShoulder().getMoveFlexion() * -1);
        }

        if (android.getRightShoulder().getMoveRotation() < 0) {
            android.getRightShoulder().setMoveRotation(android.getRightShoulder().getMoveRotation() * -1);
        }

        if (android.getNeck().getMoveRotation() < 0) {
            android.getNeck().setMoveRotation(android.getNeck().getMoveRotation() * -1);
        }

        if (android.getHead().getMoveFlexion() < 0) {
            android.getHead().setMoveFlexion(android.getHead().getMoveFlexion() * -1);
        }

        if (android.getHead().getMoveRotation() < 0) {
            android.getHead().setMoveRotation(android.getHead().getMoveRotation() * -1);
        }
    }

    public double CheckMaximumUsage(Android android) {
        double extraUse = 0;

        if (android.getLeftAnkle().getMoveFlexion() > (android.getLeftAnkle().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightAnkle().getMoveFlexion() > (android.getRightAnkle().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftKnee().getMoveFlexion() > (android.getLeftKnee().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightKnee().getMoveFlexion() > (android.getRightKnee().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftHip().getMoveFlexion() > (android.getLeftHip().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightHip().getMoveFlexion() > (android.getRightHip().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getWaist().getMoveFlexion() > (android.getWaist().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getWaist().getMoveRotation() > (android.getWaist().getRotation() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftWrist().getMoveFlexion() > (android.getLeftWrist().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightWrist().getMoveFlexion() > (android.getRightWrist().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftElbow().getMoveFlexion() > (android.getLeftElbow().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightElbow().getMoveFlexion() > (android.getRightElbow().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftShoulder().getMoveRotation() > (android.getLeftShoulder().getRotation() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getLeftShoulder().getMoveFlexion() > (android.getLeftShoulder().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightShoulder().getMoveRotation() > (android.getRightShoulder().getRotation() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getRightShoulder().getMoveFlexion() > (android.getRightShoulder().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getNeck().getMoveRotation() > (android.getNeck().getRotation() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getHead().getMoveRotation() > (android.getHead().getRotation() * 0.6)) {
            extraUse += 3.0;
        }

        if (android.getHead().getMoveFlexion() > (android.getHead().getFlexion() * 0.6)) {
            extraUse += 3.0;
        }

        return extraUse;
    }

    public double CheckTotalDegreesPerSecondFlexion(Articulation articulation) {
        double totalDegreePerSecond;

        if (articulation.getMoveFlexion() >= 15.0) {
            totalDegreePerSecond = 15.0;
        } else {
            totalDegreePerSecond = articulation.getMoveFlexion();
        }

        return totalDegreePerSecond;
    }

    public double CheckTotalDegreesPerSecondRotation(Articulation articulation) {
        double totalDegreePerSecond;

        if (articulation.getMoveRotation() >= 15.0) {
            totalDegreePerSecond = 15.0;
        } else {
            totalDegreePerSecond = articulation.getMoveRotation();
        }

        return totalDegreePerSecond;
    }

    public double CalcTotalVolts(Articulation articulation, double degreesPerSecond) {
        double totalVolts = 0;

        if (degreesPerSecond == 15.0) {
            totalVolts = articulation.getVoltsRequired();
        } else if (degreesPerSecond < 15.0) {
            totalVolts = degreesPerSecond * articulation.getVoltsPerDegree();
        }

        return totalVolts;

    }

    public double CalcBatteryProportion(double availableBattery, double totalVolts, double totalMovements, double grandTotalDegrees) {

        double proportion = 0.0;

        if (availableBattery >= totalVolts) {
            proportion = 1.0;
        } else {
            proportion = totalMovements / grandTotalDegrees;
        }

        return proportion;

    }

    public ArrayList<Articulation> PreviousPosition(Map<String, Articulation> articulations) {

        ArrayList<Articulation> previousPosition = new ArrayList();

        Iterator entries = articulations.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Articulation tempArt = new Articulation();
            tempArt = (Articulation) entry.getValue();

            Articulation ArtSave = new Articulation();
            ArtSave.setName(tempArt.getName());
            ArtSave.setFinalDegree(tempArt.getFinalDegree());
            ArtSave.setFinalRotation(tempArt.getFinalRotation());
            ArtSave.setFlexion(tempArt.getFlexion());
            ArtSave.setInitialDegree(tempArt.getInitialDegree());
            ArtSave.setMoveFlexion(tempArt.getMoveFlexion());
            ArtSave.setMoveRotation(tempArt.getMoveRotation());
            ArtSave.setRepresentativity(tempArt.getRepresentativity());
            ArtSave.setRotation(tempArt.getRotation());
            ArtSave.setVoltsRequired(tempArt.getVoltsRequired());

            previousPosition.add(ArtSave);

        }

        return previousPosition;

    }

}
