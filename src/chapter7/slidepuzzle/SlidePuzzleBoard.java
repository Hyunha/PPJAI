package chapter7.slidepuzzle;

/** SlidePuzzleBoard models a slide puzzle. */ 
public class SlidePuzzleBoard { 
	private PuzzlePiece[][] board;
	
	// 빈칸의 좌표 
	private int empty_row;
	private int empty_col;
	// representation invariant: board[empty_row][empty_col] == null
	
	/** Constructor - SlidePuzzleBoard 초기 퍼즐 보드 설정 - 증가하는 순으로, 우측하단에서 좌측하단으로 채워서 초기화 
	 * @param s - 퍼즐 보드 크기 */
	public SlidePuzzleBoard() {
		// size x size 보드 만들기
		board = new PuzzlePiece[4][4];
		// 퍼즐 조각 1~15를 보드에 역순으로 끼우기 
		int number = 1;
		for (int row = 3; row >= 0; row--)
			for (int col = 3; col >= 0; col--) {
				board[row][col] = new PuzzlePiece(number);
				number += 1;
			}
		board[0][0] = null;
		empty_row = 0;
		empty_col = 0;
	}

	/** contents - 현재 퍼즐 보드를 리턴 
    * @return 퍼즐 보드 리턴  */
	public PuzzlePiece[][] contents() { 
		return board;
	}
	
	/** 이동이 가능하면, 퍼즐 조각을 빈칸으로 이동 
	 * @param w - 이동하기 원하는 퍼즐 조각 
	 * @return 이동 성공하면 true를 리턴하고, 이동이 불가능하면 false를 리턴 */
	public boolean move(int w) { 
		int row, col; // w의 위치 
		// 빈칸에 주변에서 w의 위치를 찾음 
		if (found(w, empty_row - 1, empty_col)) {
			row = empty_row - 1;
			col = empty_col;
		}
		else if (found(w, empty_row + 1, empty_col)) {
			row = empty_row + 1;
			col = empty_col;
		}
		else if (found(w, empty_row, empty_col - 1)) {
			row = empty_row;
			col = empty_col - 1;
		}
		else if (found(w, empty_row, empty_col + 1)) {
			row = empty_row;
			col = empty_col + 1;
		}
		else
			return false;
		// w를 빈칸에 복사
		board[empty_row][empty_col] = board[row][col];
		// 빈칸 위치를 새로 설정하고, w를 제거
		empty_row = row;
		empty_col = col;
		board[empty_row][empty_col] = null;
		return true;
	}
	
	/** found - board[row][col]에 퍼즐 조각 v가 있는지 확인  */ 
	private boolean found(int v, int row, int col) { 
		if (row >= 0 && row <= 3 && col >= 0 && col <= 3)
			return board[row][col].faceValue() == v; 
	    else
	    	return false;
	}
}
	
