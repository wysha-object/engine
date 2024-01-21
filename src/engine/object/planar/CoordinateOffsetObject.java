package engine.object.planar;

import engine.core.Stage;
import engine.informationPacket.PlanarInformationPacket;
import engine.object.GeneralObject;
import engine.object.GraphicalObject;

import java.awt.*;

/**
 * @author wysha
 */
public class CoordinateOffsetObject extends GeneralObject implements GraphicalObject {
    private Image image;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getX() {
        if (targetAudienceIsJFrame){
            return isLEFT?lateralOffset:stage.getJFrameWidth()-lateralOffset;
        }else {
            return isLEFT?stage.getBackgroundX()+lateralOffset:(stage.getBackgroundX()+stage.getBackgroundWidth())-lateralOffset;
        }
    }

    @Override
    public int getY() {
        if (targetAudienceIsJFrame){
            return isUP?longitudinalOffset:stage.getJFrameHeight()-longitudinalOffset;
        }else {
            return isUP?stage.getBackgroundY()+longitudinalOffset:(stage.getBackgroundY()+stage.getBackgroundHeight())-longitudinalOffset;
        }
    }

    private int width;
    private int height;
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    /**
     * 所属舞台
     */
    private Stage stage;
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 控制是否相对于所属{@link engine.core.Stage}实例的显示区域进行坐标偏移<br/>
     * &emsp;为真则相对于显示区域<br/>
     * &emsp;为假则相对于背景<br/>
     */
    private boolean targetAudienceIsJFrame;

    public boolean isTargetAudienceIsJFrame() {
        return targetAudienceIsJFrame;
    }

    public void setTargetAudienceIsJFrame(boolean targetAudienceIsJFrame) {
        this.targetAudienceIsJFrame = targetAudienceIsJFrame;
    }

    private boolean isUP;

    public boolean isUP() {
        return isUP;
    }

    public void setUP(boolean UP) {
        isUP = UP;
    }

    /**
     * 横向偏移量
     */
    private int lateralOffset;

    public int getLateralOffset() {
        return lateralOffset;
    }

    public void setLateralOffset(int lateralOffset) {
        this.lateralOffset = lateralOffset;
    }

    private boolean isLEFT;

    public boolean isLEFT() {
        return isLEFT;
    }

    public void setLEFT(boolean LEFT) {
        isLEFT = LEFT;
    }

    /**
     * 纵向偏移量
     */
    private int longitudinalOffset;

    public int getLongitudinalOffset() {
        return longitudinalOffset;
    }

    public void setLongitudinalOffset(int longitudinalOffset) {
        this.longitudinalOffset = longitudinalOffset;
    }

    /**
     * @param targetAudienceIsJFrame 控制是否相对于所属{@link engine.core.Stage}实例的显示区域进行坐标偏移<br/>
     *                               &emsp;为真则相对于显示区域<br/>
     *                               &emsp;为假则相对于背景
     * @param isUP 控制是否相对于相对对象上端坐标偏移<br/>
     *             &emsp;为真则是<br/>
     *             &emsp;为假则否
     * @param longitudinalOffset 纵向偏移量
     * @param isLEFT 控制是否相对于相对对象左端坐标偏移<br/>
     *               &emsp;为真则是<br/>
     *               &emsp;为假则否
     * @param lateralOffset 横向偏移量
     * @see engine.core.Stage
     */
    protected CoordinateOffsetObject(
            PlanarInformationPacket planarInformationPacket,
            Image image,
            int width,
            int height,
            Stage stage,
            boolean targetAudienceIsJFrame,
            boolean isUP,
            int longitudinalOffset,
            boolean isLEFT,
            int lateralOffset
    ) {
        super(planarInformationPacket);
        this.image=image;
        this.width=width;
        this.height=height;
        this.stage=stage;
        this.targetAudienceIsJFrame = targetAudienceIsJFrame;
        this.isUP=isUP;
        this.longitudinalOffset = longitudinalOffset;
        this.isLEFT=isLEFT;
        this.lateralOffset = lateralOffset;
    }
}
