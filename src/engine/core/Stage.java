package engine.core;

import engine.object.CanBeOverlappedObject;
import engine.object.GraphicalObject;
import engine.object.OverlappingListenerObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * @author wysha
 */
public class Stage {
    private final LinkedList<GraphicalObject> graphicalObjects = new LinkedList<>();
    private final LinkedList<OverlappingListenerObject> overlappingListenerObjects = new LinkedList<>();
    private final LinkedList<CanBeOverlappedObject> canBeOverlappedObjects =new LinkedList<>();
    /**
     * 显示区域
     */
    private final JFrame jFrame = new JFrame();
    /**
     * 背景图片
     */
    private final Image background;
    /**
     * 显示区域横坐标
     */
    private int jFrameX;
    /**
     * 显示区域纵坐标
     */
    private int jFrameY;
    /**
     * 显示区域宽度
     */
    private int jFrameWidth;
    /**
     * 显示区域长度
     */
    private int jFrameHeight;
    /**
     * 背景横坐标
     */
    private int backgroundX;
    /**
     * 背景纵坐标
     */
    private int backgroundY;
    /**
     * 背景宽度
     */
    private int backgroundWidth;
    /**
     * 背景长度
     */
    private int backgroundHeight;
    /**
     * 用于绘制图像的内容窗格
     */
    private final JPanel contentPane = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            //重叠判断
            for (OverlappingListenerObject overlappingListenerObject : overlappingListenerObjects) {
                for (CanBeOverlappedObject canBeOverlappedObject : canBeOverlappedObjects) {
                    if (overlappingListenerObject!=canBeOverlappedObject){
                        //a<b
                        int a;
                        int b;

                        int c;

                        if (canBeOverlappedObject.getX() < overlappingListenerObject.getX()) {
                            a = canBeOverlappedObject.getX();
                            b = overlappingListenerObject.getX();
                            c = canBeOverlappedObject.getWidth();
                        } else {
                            a = overlappingListenerObject.getX();
                            b = canBeOverlappedObject.getX();
                            c = overlappingListenerObject.getWidth();
                        }
                        boolean x = (a + c) > b;

                        if (canBeOverlappedObject.getY() < overlappingListenerObject.getY()) {
                            a = canBeOverlappedObject.getY();
                            b = overlappingListenerObject.getY();
                            c = canBeOverlappedObject.getHeight();
                        } else {
                            a = overlappingListenerObject.getY();
                            b = canBeOverlappedObject.getY();
                            c = overlappingListenerObject.getHeight();
                        }
                        boolean y = (a + c) > b;

                        if (x && y) {
                            overlappingListenerObject.collisionListener(canBeOverlappedObject);
                        }
                    }
                }
            }

            //渲染
            super.paintComponent(g);
            g.drawImage(background, backgroundX, backgroundY, backgroundWidth, backgroundHeight, jFrame);
            for (GraphicalObject graphicalObject : graphicalObjects) {
                g.drawImage(graphicalObject.getImage(), graphicalObject.getX(), graphicalObject.getY(), graphicalObject.getWidth(), graphicalObject.getHeight(), jFrame);
            }
        }
    };

    /**
     * @param url          背景图片background路径
     * @param jFrameWidth  显示区域jFrame宽度
     * @param jFrameHeight 显示区域jFrame长度
     */
    Stage(String url, int jFrameWidth, int jFrameHeight) {
        jFrame.setContentPane(contentPane);
        this.background = new ImageIcon(url).getImage();
        this.jFrameWidth = jFrameWidth;
        this.jFrameHeight = jFrameHeight;
        Engine.execute(runnable);
    }

    public void addGraphicalObject(int index, GraphicalObject graphicalObject) {
        graphicalObjects.add(index, graphicalObject);
    }
    public void removeGraphicalObject(int index) {
        graphicalObjects.remove(index);
    }
    public void removeGraphicalObject(GraphicalObject graphicalObject) {
        graphicalObjects.remove(graphicalObject);
    }

    public void addOverlappingListenerObject(int index, OverlappingListenerObject overlappingListenerObject) {
        overlappingListenerObjects.add(index, overlappingListenerObject);
    }
    public void removeOverlappingListenerObject(int index) {
        overlappingListenerObjects.remove(index);
    }
    public void removeOverlappingListenerObject(OverlappingListenerObject overlappingListenerObject) {
        overlappingListenerObjects.remove(overlappingListenerObject);
    }

    public void addCanBeOverlappedObject(int index, CanBeOverlappedObject canBeOverlappedObject) {
        canBeOverlappedObjects.add(index, canBeOverlappedObject);
    }
    public void removeCanBeOverlappedObject(int index) {
        canBeOverlappedObjects.remove(index);
    }
    public void removeCanBeOverlappedObject(CanBeOverlappedObject canBeOverlappedObject) {
        canBeOverlappedObjects.remove(canBeOverlappedObject);
    }

    public int getJFrameX() {
        return jFrameX;
    }
    public void setJFrameX(int jFrameX) {
        this.jFrameX = jFrameX;
    }

    public int getJFrameY() {
        return jFrameY;
    }
    public void setJFrameY(int jFrameY) {
        this.jFrameY = jFrameY;
    }

    public int getJFrameWidth() {
        return jFrameWidth;
    }
    public void setJFrameWidth(int jFrameWidth) {
        this.jFrameWidth = jFrameWidth;
    }

    public int getJFrameHeight() {
        return jFrameHeight;
    }
    public void setJFrameHeight(int jFrameHeight) {
        this.jFrameHeight = jFrameHeight;
    }

    public int getBackgroundX() {
        return backgroundX;
    }
    public void setBackgroundX(int backgroundX) {
        this.backgroundX = backgroundX;
    }

    public int getBackgroundY() {
        return backgroundY;
    }
    public void setBackgroundY(int backgroundY) {
        this.backgroundY = backgroundY;
    }

    public int getBackgroundWidth() {
        return backgroundWidth;
    }
    public void setBackgroundWidth(int backgroundWidth) {
        this.backgroundWidth = backgroundWidth;
    }

    public int getBackgroundHeight() {
        return backgroundHeight;
    }
    public void setBackgroundHeight(int backgroundHeight) {
        this.backgroundHeight = backgroundHeight;
    }

    /**
     * 用于反复执行渲染任务
     */
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            jFrame.setLocation(jFrameX, jFrameY);
            jFrame.setSize(jFrameWidth, jFrameHeight);
            jFrame.repaint();
            Engine.execute(runnable);
        }
    };
}
