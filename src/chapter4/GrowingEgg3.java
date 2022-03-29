package chapter4;

import java.awt.*;
import javax.swing.*;

public class GrowingEgg3 extends JPanel {
  
  private final int NET_SIZE;

  private int egg_width_basic = 60;
  private int egg_height_basic = 40;
  private int egg_width = 60;
  private int egg_height = 40;
  private double ratio = 1.0;
  private int x = 170;
  private int y = 180;

  public GrowingEgg3() {
    JFrame f = new JFrame();
    NET_SIZE = 400;
    f.getContentPane().add(this);
    f.setTitle("Egg");
    f.setSize(NET_SIZE, NET_SIZE+28);
    f.setVisible(true);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public GrowingEgg3(int net_size) {
    JFrame f = new JFrame();
    NET_SIZE = net_size;
    ratio = (double)NET_SIZE / 400.0;
    egg_width = (int)(egg_width_basic * ratio);
    egg_height = (int)(egg_height_basic * ratio);
    x = NET_SIZE / 2 - egg_width / 2;
    y = NET_SIZE / 2 - egg_height / 2;
    f.getContentPane().add(this);
    f.setTitle("Egg");
    f.setSize(NET_SIZE, NET_SIZE+28);
    f.setVisible(true);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void paintComponent(Graphics g) {
    g.setColor(Color.green);
    g.fillRect(0, 0, NET_SIZE, NET_SIZE);
    g.setColor(Color.yellow);
    g.fillOval(x, y, egg_width, egg_height);
    egg_width += (int) (egg_width_basic * this.ratio);
    egg_height += (int) (egg_height_basic * this.ratio);
    x = NET_SIZE / 2 - egg_width / 2;
    y = NET_SIZE / 2 - egg_height / 2;
  }

  public static void main(String[] args) {
    new GrowingEgg3(600);
  }
}