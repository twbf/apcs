import java.awt.*;

class Pp1{
    public static void main(String args[]){
        DrawingPanel g = new DrawingPanel(400, 400);
        g.setBackground(Color.CYAN);
        Graphics s = g.getGraphics();
        layout(s,0,0,5,100,1);
        layout(s,10,120,4,24,5);
        layout(s,150,20,5,40,6);
        layout(s,130,275,3,36,3);
    }
    public static void layout(Graphics g, int x, int y, int circle, int size, int row){
        for(int i = 0; i<row; i++){
            for(int j = 0; j<row; j++){
                buildTarget(g,x+size*i,y+size*j,size, circle);
            }
        }
    }
    public static void buildTarget(Graphics g, int x, int y, int size, int circles){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size/2, size/2);
        g.drawRect(x + size/2, y, size/2, size/2);
        g.drawRect(x, y + size/2, size/2, size/2);
        g.drawRect(x + size/2, y + size/2, size/2, size/2);
        for (int i = 0; i<circles; i++){
            g.setColor(Color.YELLOW);
            g.fillOval(x+i*(size/circles)/2, y+ i*(size/circles)/2, size-i*(size/circles), size-i*(size/circles));
            g.setColor(Color.BLACK);
            g.drawOval(x+i*(size/circles)/2, y+ i*(size/circles)/2, size-i*(size/circles), size-i*(size/circles));
        }
    }
}
