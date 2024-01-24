package wysha.engine.object.pixelCoordinate;

import wysha.engine.informationPacket.PixelCoordinateInformationPacket;
import wysha.engine.object.GraphicalObject;
import wysha.engine.object.PixelCoordinateObject;

import javax.swing.*;
import java.awt.*;

/**
 * @author wysha
 * @see GraphicalObject
 * @see PixelCoordinateObject
 */
public class ImageObject extends PixelCoordinateObject implements GraphicalObject {

    protected ImageObject(PixelCoordinateInformationPacket pixelCoordinateInformationPacket, String url){
        super(pixelCoordinateInformationPacket);
        image=new ImageIcon(url).getImage();
    }

    private Image image;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public int getX() {
        return getPlanarPixelCoordinateObjectInformationPacket().getX();
    }

    @Override
    public int getY() {
        return getPlanarPixelCoordinateObjectInformationPacket().getY();
    }

    @Override
    public int getWidth() {
        return getPlanarPixelCoordinateObjectInformationPacket().getWidth();
    }

    @Override
    public int getHeight() {
        return getPlanarPixelCoordinateObjectInformationPacket().getHeight();
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
