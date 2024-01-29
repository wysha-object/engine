package cn.com.wysha.engine.object;

import java.awt.*;

/**
 * @author wysha
 */
public interface GraphicalObject {
    /**
     * 获取对象图片
     * @return 对象图片
     */
    Image getImage();
    /**
     * 获取横坐标
     * @return 横坐标
     */
    int getX();

    /**
     * 获取纵坐标
     * @return 纵坐标
     */
    int getY();

    /**
     * 获取横向长度
     * @return 横向长度
     */
    int getWidth();

    /**
     * 获取纵向长度
     * @return 纵向长度
     */
    int getHeight();
}
