package tankwars;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Window extends Canvas implements Runnable{
    public static boolean isCardChanged = false;
    public static  final int scale = 10;
    public static final int width = 160;
    public static  final int height = 90;
    private JFrame frame;
    private boolean running = false;
    private BufferedImage map;
    
    public Window(String name){
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, width*scale, height*scale);
        frame.add(this,BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void run() {
        createMap();
        running = true;
        addKeyListener(new KeyListener());
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;//frames per second
        
        int frames = 0;
        int ticks = 0;
        
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/nsPerTick;
            lastTime = now;
            boolean shouldRender = false;
            while(delta >= 1){
                delta-=1;
                ticks++;
                //tick();
                shouldRender = true;
            }
            if(shouldRender){
                frames++;
                if(isCardChanged){
                    renderCard();
                }
                render();
            }
            if(System.currentTimeMillis() - lastTimer >= 1000){
                lastTimer += 1000;
                System.out.println(frames+" frames, "+ticks+" ticks");
                frames = 0;
                ticks = 0;
            }
        }
    }
    
    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);   
        }  else{  
            Graphics2D g = (Graphics2D)bs.getDrawGraphics();
            g.drawImage(map, 0, 0,frame.getWidth(),frame.getHeight(),null);
            g.rotate(Math.toRadians(180),100,150);
            g.drawImage(Map.tank[0].getImage(), Map.tank[0].getX(), Map.tank[0].getY(),100,200, null);
            g.rotate(Math.toRadians(180),100,100);
            g.dispose();
            bs.show();
        }
    }
    private void renderCard(){
        isCardChanged = false;
        Graphics2D g2d = map.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        //
        g2d.dispose();
    }
    
    public void createMap(){
        int[][] gth = WorldGenerator.generate(100, 10, 10, 0.5);
        map = new BufferedImage(gth.length*scale, gth[0].length*scale+scale, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = map.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, gth.length*scale, gth[0].length*scale);
        for(int i = 0; i<gth.length;i++){
            for(int j = 0; j<gth[i].length; j++){
                if(gth[i][j]==-1){
                   g2d.drawImage(Map.bullet[0].getImage(), i*scale, j*scale, scale, scale, null);
                }
                if(gth[i][j]==1){
                   g2d.drawImage(Map.tank[0].getImage(), i*scale, j*scale, scale, scale, null);
                }
            }
        }
        g2d.dispose();
    }
    
}
