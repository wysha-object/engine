package engine.informationPacket;

import engine.core.Stage;

/**
 * @author wysha
 * @see Stage
 */
public class PlanarInformationPacket {
    /**
     * 宽度
     */
    private int width;

    /**
     * 高度
     */
    private int height;

    PlanarInformationPacket(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
