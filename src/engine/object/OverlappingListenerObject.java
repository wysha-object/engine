package engine.object;

/**
 * @author wysha
 */
public interface OverlappingListenerObject {
    void collisionListener(CanBeOverlappedObject canBeOverlappedObject);
    int getX();
    int getY();
    int getWidth();
    int getHeight();
}
