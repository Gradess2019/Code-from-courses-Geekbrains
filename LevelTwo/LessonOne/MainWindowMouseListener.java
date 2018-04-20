package Homework.LevelTwo.LessonOne;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindowMouseListener implements MouseListener {

    private MainWindow mainWindow;

    MainWindowMouseListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Sprite[] sprites = mainWindow.getSprites();
        Sprite[] temp = new Sprite[sprites.length+1];
        System.arraycopy(sprites, 0, temp, 0, sprites.length);
        temp[temp.length-1] = new Ball();
        mainWindow.setSprites(temp);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
