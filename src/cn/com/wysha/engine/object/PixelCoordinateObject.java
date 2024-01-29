package cn.com.wysha.engine.object;

import cn.com.wysha.engine.informationPacket.PixelCoordinateInformationPacket;

/**
 * @author wysha
 */
public class PixelCoordinateObject {
    protected PixelCoordinateObject(PixelCoordinateInformationPacket pixelCoordinateInformationPacket) {
        this.pixelCoordinateInformationPacket = pixelCoordinateInformationPacket;
    }

    private PixelCoordinateInformationPacket pixelCoordinateInformationPacket;

    public PixelCoordinateInformationPacket getPlanarPixelCoordinateObjectInformationPacket() {
        return pixelCoordinateInformationPacket;
    }

    public void setPlanarPixelCoordinateObjectInformationPacket(PixelCoordinateInformationPacket pixelCoordinateInformationPacket) {
        this.pixelCoordinateInformationPacket = pixelCoordinateInformationPacket;
    }
}
