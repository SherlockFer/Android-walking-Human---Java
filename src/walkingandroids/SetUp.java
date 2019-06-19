
package walkingandroids;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author fabriciobarros
 * @author aldanalouzan
 */
public class SetUp {

    public SetUp() {
    }

    public Android CreateAndroid(String filename) throws IOException {
        FileInputStream fs = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));

        String line = br.readLine();
        String[] leftAnkle = line.split(",");
        line = br.readLine();
        String[] rightAnkle = line.split(",");
        line = br.readLine();
        String[] leftKnee = line.split(",");
        line = br.readLine();
        String[] rightKnee = line.split(",");
        line = br.readLine();
        String[] leftHip = line.split(",");
        line = br.readLine();
        String[] rightHip = line.split(",");
        line = br.readLine();
        String[] waist = line.split(",");
        line = br.readLine();
        String[] leftWrist = line.split(",");
        line = br.readLine();
        String[] rightWrist = line.split(",");
        line = br.readLine();
        String[] leftElbow = line.split(",");
        line = br.readLine();
        String[] rightElbow = line.split(",");
        line = br.readLine();
        String[] leftShoulder = line.split(",");
        line = br.readLine();
        String[] rightShoulder = line.split(",");
        line = br.readLine();
        String[] neck = line.split(",");
        line = br.readLine();
        String[] head = line.split(",");

        Ankle leftAnkleNew = new Ankle(leftAnkle[0], Integer.parseInt(leftAnkle[1]), Integer.parseInt(leftAnkle[2]));
        Ankle rightAnkleNew = new Ankle(rightAnkle[0], Integer.parseInt(rightAnkle[1]), Integer.parseInt(rightAnkle[2]));
        Elbow leftElbowNew = new Elbow(leftElbow[0], Integer.parseInt(leftElbow[1]), Integer.parseInt(leftElbow[2]));
        Elbow rightElbowNew = new Elbow(rightElbow[0], Integer.parseInt(rightElbow[1]), Integer.parseInt(rightElbow[2]));
        Head headNew = new Head(head[0], Integer.parseInt(head[1]), Integer.parseInt(head[2]), Integer.parseInt(head[3]));
        Hip leftHipNew = new Hip(leftHip[0], Integer.parseInt(leftHip[1]), Integer.parseInt(leftHip[2]));
        Hip rightHipNew = new Hip(rightHip[0], Integer.parseInt(rightHip[1]), Integer.parseInt(rightHip[2]));
        Knee leftKneeNew = new Knee(rightKnee[0], Integer.parseInt(rightKnee[1]), Integer.parseInt(rightKnee[2]));
        Knee rightKneeNew = new Knee(leftKnee[0], Integer.parseInt(leftKnee[1]), Integer.parseInt(leftKnee[2]));
        Neck neckNew = new Neck(neck[0], Integer.parseInt(neck[1]), Integer.parseInt(neck[2]));
        Shoulder leftShoulderNew = new Shoulder(leftShoulder[0], Integer.parseInt(leftShoulder[1]), Integer.parseInt(leftShoulder[2]), Integer.parseInt(leftShoulder[3]));
        Shoulder rightShoulderNew = new Shoulder(rightShoulder[0], Integer.parseInt(rightShoulder[1]), Integer.parseInt(rightShoulder[2]), Integer.parseInt(rightShoulder[3]));
        Waist waistNew = new Waist(waist[0], Integer.parseInt(waist[1]), Integer.parseInt(waist[2]), Integer.parseInt(waist[3]));
        Wrist leftWristNew = new Wrist(leftWrist[0], Integer.parseInt(leftWrist[1]), Integer.parseInt(leftWrist[2]));
        Wrist rightWristNew = new Wrist(rightWrist[0], Integer.parseInt(rightWrist[1]), Integer.parseInt(rightWrist[2]));;

        Android walkingAndroid = new Android(leftAnkleNew, rightAnkleNew, leftElbowNew, rightElbowNew, headNew, leftHipNew, rightHipNew, leftKneeNew, rightKneeNew, neckNew, leftShoulderNew, rightShoulderNew, waistNew, leftWristNew, rightWristNew);

        return walkingAndroid;

    }

}
