package lecture.four.robot;

public class MoveRobot {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotConnection;
        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
            } catch (RobotConnectionException e) {
                continue;
            }

            try {
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
            } finally {
                try {
                    robotConnection.close();
                } catch (RobotConnectionException e) {
                }
            }
        }throw new RobotConnectionException("Failed to connect. Please try again.");
    }
}