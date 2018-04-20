package Homework.LevelTwo.LessonOne;

import java.awt.*;

public class Background {

    private Color backgroundColor;
    private int deltaRed;
    private int deltaGreen;
    private int deltaBlue;
    private int countToChangeDelta;
    Background() {
        backgroundColor = new Color(
                (int) (Math.random() * 255f),
                (int) (Math.random() * 255f),
                (int) (Math.random() * 255f)
        );
        deltaRed = (int) (Math.random() * 3f) + 1;
        deltaGreen = (int) (Math.random() * 3f) + 1;
        deltaBlue = (int) (Math.random() * 3f) + 1;
        countToChangeDelta = (int) (Math.random() * 1000f);
    }

    public void newColor(GameCanvas gameCanvas) {
        if(backgroundColor.getRed() >= (255 - deltaRed) ||
                backgroundColor.getRed() <= Math.abs(deltaRed)) deltaRed = -deltaRed;
        if(backgroundColor.getGreen() >= (255 - deltaGreen) ||
                backgroundColor.getGreen() <= Math.abs(deltaGreen)) deltaGreen = -deltaGreen;
        if(backgroundColor.getBlue() >= (255 - deltaBlue) ||
                backgroundColor.getBlue() <= Math.abs(deltaBlue)) deltaBlue = -deltaBlue;

        backgroundColor = new Color(
                backgroundColor.getRed() + deltaRed,
                backgroundColor.getGreen() + deltaGreen,
                backgroundColor.getGreen() + deltaBlue
        );
        gameCanvas.setBackground(backgroundColor);

        if (countToChangeDelta > 0) countToChangeDelta--;
        else {
            deltaRed = (int) (Math.random() * 3f) + 1;
            deltaGreen = (int) (Math.random() * 3f) + 1;
            deltaBlue = (int) (Math.random() * 3f) + 1;
            countToChangeDelta = (int) (Math.random() * 1000f);
        }
    }
}
