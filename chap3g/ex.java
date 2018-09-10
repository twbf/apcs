import java.awt.*;
import java.util.*;

class Ex{
    public static void main(String args[]){
        String[] notes= {"a", "b", "c", "e", "a", "b", "e", "d"};
        int len = notes.length;
        DrawingPanel g = new DrawingPanel(300, 100);
        Graphics s = g.getGraphics();
        int size = 200;
        int space = 16;
        for (int i = 0; i<5; i++){
            s.drawLine(25, 30 + space*i, 25+size, 30 + space*i);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "5");
        map.put("b", "4");
        map.put("c", "3");
        map.put("d", "2");
        map.put("e", "1");
        for(int i = 0; i<len; i++){
            int h = Integer.parseInt(map.get(notes[i]));
            s.fillOval(30 + i*(size/len), 27 + h*8, 9, 9);
        }
    }
}
