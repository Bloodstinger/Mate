package lecture.four.robot;

public interface RobotConnection extends AutoCloseable{
    void moveRobotTo(int toX, int toY);
    @Override
    void close();
}
