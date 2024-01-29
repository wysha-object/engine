package cn.com.wysha.engine.informationPacket;

import cn.com.wysha.engine.core.Stage;

/**
 * @author wysha
 * @see Stage
 * @see PlanarInformationPacket
 */
public class PixelCoordinateInformationPacket extends PlanarInformationPacket {

    /**
     * 横坐标
     */
    private int x;

    /**
     * 纵坐标
     */
    private int y;

    public PixelCoordinateInformationPacket(int x, int y, int width, int height) {
        super(width, height);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
