package com.examples.demo;

/**
 * cerner_2^5_2017
 */
public class FillNeighbors {
	/**
	 * cerner_2^5_2017 
	 * If the given cell(row,col) has a oNum passed, then
	 * replace it with the replaceNum
	 * @return boolean
	 */
	public static boolean replaceNeighbors(int[][] grid, int row, int col,
			int oNum, int replaceNum) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
			return false;
		if (grid[row][col] == oNum) {
			grid[row][col] = replaceNum;
			// cell below
			replaceNeighbors(grid, row + 1, col, oNum, replaceNum);
			// cell above
			replaceNeighbors(grid, row - 1, col, oNum, replaceNum);
			// left cell
			replaceNeighbors(grid, row, col + 1, oNum, replaceNum);
			// right cell
			replaceNeighbors(grid, row + 1, col - 1, oNum, replaceNum);
			// top-left diagonal
			replaceNeighbors(grid, row - 1, col - 1, oNum, replaceNum);
			// top-right diagonal
			replaceNeighbors(grid, row - 1, col + 1, oNum, replaceNum);
			// below right diagonal
			replaceNeighbors(grid, row + 1, col + 1, oNum, replaceNum);
			// below left diagonal
			replaceNeighbors(grid, row + 1, col - 1, oNum, replaceNum);
		}
		return true;
	}

}
