package com.sinius15.tetrislp;

import com.sinius15.launchpad.Launchpad;

public class Blocks {

	public static Block i = new Block(new boolean[][][] {
			{
				{false,	false,	false,	false},
				{true,	true,	true,	true},
				{false,	false,	false,	false},
				{false,	false,	false,	false}
			},
			{
				{false,	false,	true,	false},
				{false,	false,	true,	false},
				{false,	false,	true,	false},
				{false,	false,	true,	false}
			},
			{
				{false,	false,	false,	false},
				{false,	false,	false,	false},
				{true,	true,	true,	true},
				{false,	false,	false,	false}
			},
			{
				{false,	true,	false,	false},
				{false,	true,	false,	false},
				{false,	true,	false,	false},
				{false,	true,	false,	false}
			}
		}, Launchpad.COLOR_RED_FULL);
		
	public static Block j = new Block(new boolean[][][] {
			{
				{true,	false,	false},
				{true,	true,	true},
				{false,	false,	false}
			},
			{
				{false,	true,	true},
				{false,	true,	false},
				{false,	true,	false}
			},
			{
				{false,	false,	false},
				{true,	true,	true},
				{false,	false,	true}
			},
			{
				{false,	true,	false},
				{false,	true,	false},
				{true,	true,	false}
			}
		}, Launchpad.COLOR_RED_LOW);
		
	public static Block l = new Block(new boolean[][][] {
			{
				{false,	false,	true},
				{true,	true,	true},
				{false,	false,	false}
			},
			{
				{false,	true,	false},
				{false,	true,	false},
				{false,	true,	true}
			},
			{
				{false,	false,	false},
				{true,	true,	true},
				{true,	false,	false}
			},
			{
				{true,	true,	false},
				{false,	true,	false},
				{false,	true,	false}
			}
		}, Launchpad.COLOR_AMBER_FULL);
		
	public static Block o = new Block(new boolean[][][] {
			{
				{true,	true},
				{true,	true}
			},
			{
				{true,	true},
				{true,	true}
			},
			{	
				{true,	true},
				{true,	true}
			},
			{
				{true,	true},
				{true,	true}
			}
		}, Launchpad.COLOR_AMBER_LOW);
		
	public static Block s = new Block(new boolean[][][] {
			{
				{false,	true, true},
				{true,	true, false},
				{false,	false,false}
			},
			{
				{false,	true,	false},
				{false,	true,	true},
				{false,	false,	true}
			},
			{
				{false,	false,	false},
				{false,	true,	true},
				{true,	true,	false}
			},
			{
				{true,	false,	false},
				{true,	true,	false},
				{false,	true,	false}
			}
		}, Launchpad.COLOR_GREEN_FULL);
		
	public static Block t = new Block(new boolean[][][] {
			{
				{false,	true,	false},
				{true,	true,	true},
				{false,	false,	false}
			},
			{
				{false,	true,	false},
				{false,	true,	true},
				{false,	true,	false}
			},
			{
				{false,	false,	false},
				{true,	true,	true},
				{false,	true,	false}
			},
			{
				{false,	true,	false},
				{true,	true,	false},
				{false,	true,	false}
			}
		}, Launchpad.COLOR_YELLOW_FULL);

	public static Block z = new Block(new boolean[][][] {
			{
				{true,	true,	false},
				{false,	true,	true},
				{false,	false,	false}
			},
			{
				{false,	false,	true},
				{false,	true,	true},
				{false,	true,	false}
			},
			{
				{false,	false,	false},
				{true,	true,	false},
				{false,	true,	true}
			},
			{
				{false,	true,	false},
				{true,	true,	false},
				{true,	false,	false}
			}
		}, Launchpad.COLOR_GREEN_LOW);
	
}
