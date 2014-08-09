package com.sinius15.tetrislp;

import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

public class Block{
	
	private boolean[][][] data;
	private int rotation;  //can be 0,1,2,3
	public int color;
	public Point location; //row, col
	
	public Block(boolean[][][] data, int color){
		this.color = color;
		this.data = data;
		this.rotation = 0;
		location = new Point(0, 4);
	}
	
	public boolean isOnThisSpot(int row, int col){
		try{
			return data[rotation][row-location.x][col-location.y];
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
	}
	
	public void setLocation(Point p){
		this.location = p;
	}
	
	public void rotateRight(){
		rotation++;
		if(rotation == 4)
			rotation = 0;
	}
	public void rotateLeft(){
		rotation--;
		if(rotation == -1)
			rotation = 3;
	}
	
	protected Block copy(){
		return new Block(Arrays.copyOf(data, data.length), color);
	}
	
	private static Random random = new Random();
	public static Block getNewRandomBlock(){
		switch (random.nextInt(7)) {
			case 0:
				return Blocks.i.copy();
			case 1:
				return Blocks.j.copy();
			case 2:
				return Blocks.s.copy();
			case 3:
				return Blocks.z.copy();
			case 4:
				return Blocks.o.copy();
			case 5:
				return Blocks.l.copy();
			case 6:
				return Blocks.t.copy();
			default:
				return null;
		}
//		return Blocks.i.copy();
	}
	
}
