import java.awt.*;

class Ex{
    public static void main(String args[]){
        DrawingPanel g = new DrawingPanel(100, 100);
        Graphics s = g.getGraphics();
        s.drawLine(25, 75, 175, 25);
    }
}
