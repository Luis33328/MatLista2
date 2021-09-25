package com.ex3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Relogio {

	private int seconds = 0;
	private int minR = 0, minL = 0, hR = 0, hL = 0;
	public int time = 0;
	public String state = "SELECT";
	
	public boolean up = false, down = false, left = false, right = false, enter = false;
	
	public int curPos = 0;
	private boolean blink = false;
	private int framesB = 0;
	
	private int frames = 0, maxFrames = 2, index = 0, maxIndex = 55;
	private BufferedImage[] background;
	
	//private String hours[] = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", };

	
	public Relogio() {
		
		for(int i = 0; i<24; i++) {
			for(int j = 0; j<60; j++) {
				System.out.println(i + ":" + j);
			}
		}
		
		background = new BufferedImage[55];
		
		for(int i = 0; i < 55; i++) {
			background[0] = Main.spritesheet.getSprite(0,0,480,480);
			background[1] = Main.spritesheet.getSprite(482,0,480,480);
			background[2] = Main.spritesheet.getSprite(964,0,480,480);
			background[3] = Main.spritesheet.getSprite(1446,0,480,480);
			background[4] = Main.spritesheet.getSprite(1928,0,480,480);
			background[5] = Main.spritesheet.getSprite(2410,0,480,480);
			background[6] = Main.spritesheet.getSprite(2892,0,480,480);
			background[7] = Main.spritesheet.getSprite(3374,0,480,480);
			background[8] = Main.spritesheet.getSprite(3856,0,480,480);
			background[9] = Main.spritesheet.getSprite(4338,0,480,480);
			background[10] = Main.spritesheet.getSprite(0,482,480,480);
			background[11] = Main.spritesheet.getSprite(482,482,480,480);
			background[12] = Main.spritesheet.getSprite(964,482,480,480);
			background[13] = Main.spritesheet.getSprite(1446,482,480,480);
			background[14] = Main.spritesheet.getSprite(1928,482,480,480);
			background[15] = Main.spritesheet.getSprite(2410,482,480,480);
			background[16] = Main.spritesheet.getSprite(2892,482,480,480);
			background[17] = Main.spritesheet.getSprite(3374,482,480,480);
			background[18] = Main.spritesheet.getSprite(3856,482,480,480);
			background[19] = Main.spritesheet.getSprite(4338,482,480,480);
			background[20] = Main.spritesheet.getSprite(0,964,480,480);
			background[21] = Main.spritesheet.getSprite(482,964,480,480);
			background[22] = Main.spritesheet.getSprite(964,964,480,480);
			background[23] = Main.spritesheet.getSprite(1446,964,480,480);
			background[24] = Main.spritesheet.getSprite(1928,964,480,480);
			background[25] = Main.spritesheet.getSprite(2410,964,480,480);
			background[26] = Main.spritesheet.getSprite(2892,964,480,480);
			background[27] = Main.spritesheet.getSprite(3374,964,480,480);
			background[28] = Main.spritesheet.getSprite(3856,964,480,480);
			background[29] = Main.spritesheet.getSprite(4338,964,480,480);
			background[30] = Main.spritesheet.getSprite(0,1446,480,480);
			background[31] = Main.spritesheet.getSprite(482,1446,480,480);
			background[32] = Main.spritesheet.getSprite(964,1446,480,480);
			background[33] = Main.spritesheet.getSprite(1446,1446,480,480);
			background[34] = Main.spritesheet.getSprite(1928,1446,480,480);
			background[35] = Main.spritesheet.getSprite(2410,1446,480,480);
			background[36] = Main.spritesheet.getSprite(2892,1446,480,480);
			background[37] = Main.spritesheet.getSprite(3374,1446,480,480);
			background[38] = Main.spritesheet.getSprite(3856,1446,480,480);
			background[39] = Main.spritesheet.getSprite(4338,1446,480,480);
			background[40] = Main.spritesheet.getSprite(0,1928,480,480);
			background[41] = Main.spritesheet.getSprite(482,1928,480,480);
			background[42] = Main.spritesheet.getSprite(964,1928,480,480);
			background[43] = Main.spritesheet.getSprite(1446,1928,480,480);
			background[44] = Main.spritesheet.getSprite(1928,1928,480,480);
			background[45] = Main.spritesheet.getSprite(2410,1928,480,480);
			background[46] = Main.spritesheet.getSprite(2892,1928,480,480);
			background[47] = Main.spritesheet.getSprite(3374,1928,480,480);
			background[48] = Main.spritesheet.getSprite(3856,1928,480,480);
			background[49] = Main.spritesheet.getSprite(4338,1928,480,480);
			background[50] = Main.spritesheet.getSprite(0,2410,480,480);
			background[51] = Main.spritesheet.getSprite(482,2410,480,480);
			background[52] = Main.spritesheet.getSprite(964,2410,480,480);
			background[53] = Main.spritesheet.getSprite(1446,2410,480,480);
			background[54] = Main.spritesheet.getSprite(1928,2410,480,480);

		}
	}
	
	public void proximoMinuto() {
		minR = minR + 1;
	}
	
	public void tick() {
		
		
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index == maxIndex) {
				index = 0;
			}
		}
		
		if(hL == 2 && hR == 4) {
			hL = 0;
			hR  = 0;
			minL = 0;
			minR = 0;
		}
		else if(hL == 2 && hR == 9) {
			hL = 2;
			hR  = 3;
			minL = 5;
			minR = 9;
		}
		
		if(state == "SELECT") {
			framesB++;
			if (framesB == 25) {
				framesB = 0;
		        if (blink) {
		        	blink = false;
		        } else {
		        	blink = true;
		        } 
		    } 
			
			
			if(up == true) {
				switch(curPos) {
					case 0:
						hR++;
						if(hR > 9) {
							hR = 0;
							hL++;
							if(hL > 2) {
								hL = 0;
							}
						}
						break;
					
					case 1:
						minR++;
						if(minR > 9) {
							minR = 0;
							minL++;
							if(minL >= 6) {
								minL = 0;
							}
						}
						break;
				}
				
				up = false;	
			}
			
			else if(down == true) {
				switch(curPos) {
				case 0:
					hR--;
					if(hR < 0) {
						hR = 9;
						hL--;
						if(hL < 0) {
							hL = 2;
						}
					}
					break;
				
				case 1:
					minR--;
					if(minR < 0) {
						minR = 9;
						minL--;
						if(minL < 0) {
							minL = 5;
						}
					}
					break;
				}
			
				down = false;
			}
			
			else if(right == true) {
				curPos++;
				if(curPos > 1) {
					curPos = 0;
				}
				else if(curPos < 0) {
					curPos = 1;
				}
				right = false;
			}
			else if(left == true) {
				curPos--;
				if(curPos < 0) {
					curPos = 1;
				}
				left = false;
					
			}
			
			else if(enter == true) {
				state = "CLOCK";
				curPos = 3;
				enter = false;
			}
		}
		
		else if(state == "CLOCK") {
			time++;
			
			if(time >= 3600) {
				time = 0;
				minR++;
				
			}
			if(minR > 9) {
				minR = 0;
				minL++;
				if(minL >= 6) {
					minL = 0;
					hR++;
					if(hR > 9 && hL != 2) {
						hR = 0;
						hL++;
					}
					else if(hR > 3 && hL == 2) {
						hR = 0;
						hL = 0;
					}
				}
			}
			
			
			
			if(enter == true) {
				proximoMinuto();
				enter = false;
			}
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(background[index], 0,0, null);
		g.setFont(new Font("arial", Font.BOLD, 12));
		
		
		
		
		g.setColor(Color.BLACK);
		g.fillRect(125,170,230,100);
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(time),325,260);
		
		g.setFont(Main.alarmFont);
		g.setColor(Color.WHITE);
		//g.drawString("00:28" ,150,245);

		g.drawString(":",232,245);

		
		
		if(blink == true) {
			if(curPos == 0) {
				g.drawString(String.valueOf(hL),150,245);
				g.drawString(String.valueOf(hR),191,245);
			}
			else if(curPos == 1) {
				g.drawString(String.valueOf(minL),251,245);
				g.drawString(String.valueOf(minR),292,245);
			}
		}
		if(curPos != 0) {
			g.drawString(String.valueOf(hL),150,245);
			g.drawString(String.valueOf(hR),191,245);
		}
		if(curPos != 1) {
			g.drawString(String.valueOf(minL),251,245);
			g.drawString(String.valueOf(minR),292,245);
		}

	}
	
}
