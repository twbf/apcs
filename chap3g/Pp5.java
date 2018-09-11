import java.awt.*;

class Pp5{
    public static void main(String args[]){
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();
        layout(g,0,0,4,1,20,0);
        layout(g,50,70,5,1,30,0);
        layout(g,10,150,4,8,25,0);
        layout(g,250,200,3,6,25,10);
        layout(g,425,180,5,10,20,10);
        layout(g,400,20,2,4,35,35);
    }
    public static void layout(Graphics g, int x, int y, int numPairs, int numRows, int size, int offset){
        int off = 0;
        for(int i = 0; i<numRows; i++){
            int nY = y + i*size;
            if (i%2 == 0){
                off = offset;
            }
            if (i%2 == 1){
                off = 0;
            }
            for(int j = 0; j<numPairs; j++){
                int nX = x + size*(2*j - 1) + off;

                g.setColor(Color.BLACK);
                g.fillRect(nX, nY, size, size);
                g.setColor(Color.WHITE);
                g.drawLine(nX+5, nY+5, nX+size-5, nY+size-5);
                g.drawLine(nX+5, nY+5, nX+size-5, nY+size-5);
                //black

                //white
                nX = x + 2*j*size + off;
                g.setColor(Color.WHITE);
                g.fillRect(nX, nY, size, size);
            }
        }
    }
}
