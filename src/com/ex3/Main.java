package com.ex3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	
	private BufferedImage image;
	public boolean isRunning = true;
	public static final int WIDTH = 240;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	public static Spritesheet spritesheet;
	public Relogio clock;
	public InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("alarm_clock.ttf");
	public static Font alarmFont;
	
	
	public Main(){
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		addKeyListener(this);
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		try {
			alarmFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(70f);
		} catch (FontFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		spritesheet = new Spritesheet("/spritesheet.png");
		clock = new Relogio();
		
	}
	
	public void initFrame() {
		frame = new JFrame("Relógio");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Main relogio = new Main();
		relogio.start();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void tick() {
		clock.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0,WIDTH,HEIGHT);		
		
		
		g.dispose();
		g = bs.getDrawGraphics();
		//g.drawImage(image, 0, 0,Toolkit.getDefaultToolkit().getScreenSize().width*2,Toolkit.getDefaultToolkit().getScreenSize().height*2,null);
		
		g.drawImage(image, 0, 0,(WIDTH*SCALE),(HEIGHT*SCALE),null);
		g.setFont(new Font("arial",Font.BOLD,20));
		g.setColor(Color.white);
		
		clock.render(g);
		
		
		bs.show();
		
	}

	@Override
	
	
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			clock.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			clock.left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			clock.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			clock.down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			clock.enter = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				//System.out.println("FPS: "+ frames);
				frames = 0;
				timer+=1000;
			}
			
		}
		
		stop();
		
		
	}

}
