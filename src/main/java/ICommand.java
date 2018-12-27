import bean.Position;

public interface ICommand {


    /**
     * 关闭ros系统
     */
    void shutdown();

    /**
     * @param position 目标位置
     */
    void moveTo(Position position);

    /**
     * 获取当前的位置坐标
     * @return 当前位置
     */
    Position getCurrentPosition();

    /**
     * 回到起始地点
     */
    void moveToStart();




}
