package cn.com.wysha.engine.object;

import cn.com.wysha.engine.informationPacket.PlanarInformationPacket;

/**
 * @author wysha
 */
public class GeneralObject {
    protected GeneralObject(PlanarInformationPacket planarInformationPacket) {
        this.planarInformationPacket = planarInformationPacket;
    }

    private PlanarInformationPacket planarInformationPacket;

    public PlanarInformationPacket getObjectInformationPacket() {
        return planarInformationPacket;
    }

    public void setObjectInformationPacket(PlanarInformationPacket planarInformationPacket) {
        this.planarInformationPacket = planarInformationPacket;
    }
}
