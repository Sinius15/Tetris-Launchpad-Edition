package com.sinius15.tetrislp;

import javax.sound.midi.MidiUnavailableException;

import com.sinius15.launchpad.BufferedLaunchpad;
import com.sinius15.launchpad.LPRack;
import com.sinius15.launchpad.LaunchpadException;

public class Tetris {

	public static Thread mainThread;

	BufferedLaunchpad launchpad;

	boolean running = true;
	boolean speedup = false;
	int score = 0;
	int speed = 1000;
	LPRack actions;

	// [row][col], 0 means air, else the color is
	int[][] board = new int[9][8];
	Block block = null;

	private Tetris(String padName) {
		mainThread = Thread.currentThread();
		try {
			launchpad = new BufferedLaunchpad(padName);
			launchpad.open();
			actions = new LPRack(launchpad);
			initActions();
		} catch (LaunchpadException | MidiUnavailableException e1) {
			e1.printStackTrace();
		}

		while (running) {
			if (block == null) {
				block = Block.getNewRandomBlock();
				speedup = false;
			} else if (!canBlockMoveDown()) {
				moveTileToBoard();
				block = null;
			} else {
				block.location.x++;
			}
			doBottomRow();
			drawToPad();
			try {
				if (!speedup)
					Thread.sleep(speed);
			} catch (InterruptedException e) {
			}
		}
		launchpad.close();
		System.out.println("Score: " + score);
	}

	private void initActions() {
		actions.setOnButtonDown(8, 5, moveLeft);
		actions.setOnButtonDown(8, 7, moveRight);
		actions.setOnButtonDown(1, 8, stopGame);
		actions.setOnButtonDown(7, 6, turnRight);
		
		actions.setOnButtonDown(8, 6, speedUp);
		actions.setOnButtonUp(8, 6, speedDown);
	}

	Runnable moveLeft = new Runnable() {
		@Override
		public void run() { // move left
			if (block != null) {
				if (canBlockMoveLeft())
					block.location.y--;
				drawToPad();
			}
		}
	};
	Runnable moveRight = new Runnable() {
		@Override
		public void run() { // move right
			if (block != null) {
				if (canBlockMoveRight())
					block.location.y++;
				drawToPad();
			}
		}
	};
	Runnable turnLeft = new Runnable() {
		@Override
		public void run() { // turn left
			if (block != null) {
				block.rotateLeft();
				if (isBlockValidLocation())
					drawToPad();
				else
					block.rotateRight();
			}
		}
	};
	Runnable turnRight = new Runnable() {
		@Override
		public void run() { // turn right
			if (block != null) {
				block.rotateRight();
				if (isBlockValidLocation())
					drawToPad();
				else
					block.rotateLeft();
			}
		}
	};
	Runnable stopGame = new Runnable() {
		@Override
		public void run() { // stop game
			running = false;
			mainThread.interrupt();
		}
	};
	Runnable speedUp = new Runnable() {
		@Override
		public void run() { // speed up
			speedup = true;
			mainThread.interrupt();
		}
	};
	Runnable speedDown = new Runnable() {
		@Override
		public void run() { // speed up
			speedup = false;
		}
	};

	public void drawToPad() {
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 8; col++) {
				if (board[row][col] != 0)
					launchpad.setLedOn(col, row, board[row][col]);
				else if (block != null && block.isOnThisSpot(row, col)) {
					launchpad.setLedOn(col, row, block.color);
				}else{
					launchpad.setLedOff(col, row);
				}
			}
	}

	public boolean canBlockMoveDown() {
		block.location.x++;
		boolean b = isBlockValidLocation();
		block.location.x--;
		return b;
	}

	public boolean canBlockMoveLeft() {
		block.location.y--;
		boolean b = isBlockValidLocation();
		block.location.y++;
		return b;
	}

	public boolean canBlockMoveRight() {
		block.location.y++;
		boolean b = isBlockValidLocation();
		block.location.y--;
		return b;
	}

	public void moveTileToBoard() {
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 8; col++)
				if (block.isOnThisSpot(row, col))
					board[row][col] = block.color;
	}

	public boolean isBlockValidLocation() {
		for (int i = 0; i < 8; i++) {
			if (block.isOnThisSpot(9, i))
				return false;
			if (block.isOnThisSpot(i, 8))
				return false;
			if (block.isOnThisSpot(i, -1))
				return false;
		}
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 8; col++) {
				if (board[row][col] != 0 && block.isOnThisSpot(row, col)) {
					return false;
				}
			}
		}
		return true;
	}

	public void doBottomRow() {
		for (int row = 8; row >= 0; row--) {
			if(isRowFull(row)){
				for(int curRow = row; curRow > 0; curRow--){
					board[curRow] = board[curRow-1];
				}
			}
		}
	}
	
	public boolean isRowFull(int row){
		for(int i = 0; i < 8; i++){
			if(board[row][i] == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new Tetris("Launchpad S"); // <- this should not be a string...
	}
}
