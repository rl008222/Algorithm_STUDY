package a0401;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1194_달이차오른다가자 {
	static class Point {
		int row;
		int col;
		/**
		 * status : 열쇠의 보유현황을 표시합니다
		 * 2진법으로 표시했을 때
		 * 000000 (0) : 아무 열쇠도 없음
		 * 000001 (1) : a번 열쇠를 획득한 상태
		 * 001010 (10) : d번 열쇠, b번 열쇠를 획득한 상태
		 * 이런식으로 저장됩니다.
		 */
		int status;

		public Point() {
			super();
		}

		public Point(int row, int col, int status) {
			super();
			this.row = row;
			this.col = col;
			this.status = status;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N + 2][M + 2];
		/**
		 * visitStatus [a][b][c] : 해당 지점(a, b)에 c의 status로 방문한 적이 있는지 여부를 저장하는 것.
		 * 1 << 6은 그냥 열쇠가 6개 있어서 6비트 사용하겠다는 뜻으로 쓴 것이고 그냥 64와 같다.
		 */
		boolean[][][] visitStatus = new boolean[N + 2][M + 2][1 << 6];
		Point startPoint = new Point();
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
				if (map[i][j] == '0') {
					// 민식이 위치는 빈 칸으로 등록한다.
					map[i][j] = '.';
					startPoint.row = i;
					startPoint.col = j;
					// 초기에는 열쇠 획득을 하지 못하였으니, status가 0이다.
					startPoint.status = 0;
				}
			}
		}
		
		/**
		 * queue : 같은 최소 이동 횟수를 가지는 위치와 key상태를 저장한 후 탐색을 돌리는 큐
		 */
		LinkedList<Point> queue = new LinkedList<>();
		queue.add(startPoint);
		visitStatus[startPoint.row][startPoint.col][startPoint.status] = true;
		int moveCount = 0;
		/**
		 * 큐가 비어있지 않다면 비거나 종료위치를 찾을 때까지 반복한다.
		 */
		while(!queue.isEmpty()) {
			/**
			 * nextQueue :
			 *  한 queue 내의 원소에 대해서 같은 최소 이동 횟수를 보장하기 위해
			 *  queue에서 탐색한 지점의 다음 이동지점(이동 횟수 + 1인 지점)을 nextQueue에 저장해두고
			 *  이번 이동 횟수에 대한 탐색이 끝나면 다시 queue = nextQueue를 하여
			 *  한 queue 내의 원소에 대해 같은 이동횟수임을 보장하기 위해 사용.
			 *  만약 이렇게 하지 않는다면 Node(이 코드에서는 Point)에 int형의 이동횟수를 저장해서 메모리를 더 쓰거나
			 *  지속적으로 같은 이동횟수를 가지는 Node의 수를 체크해서 한 턴에 그만큼 빼는식의 직관적으로 이해하기 어려운 코드를 사용해야한다.
			 */
			LinkedList<Point> nextQueue = new LinkedList<>();
			/**
			 * 이 위치에서는 이동횟수를 증가시키고 그 이동횟수 queue에 대해 탐색하므로 이동 횟수를 올려준다.
			 */
			moveCount++;
			/**
			 * 같은 이동횟수를 가진 Node에 대해서 queue가 비워질 때까지 탐색
			 */
			while(!queue.isEmpty()) {
				Point now = queue.poll();
				for(int d = 0; d < 4; d++) {
					int nextRow = now.row + dr[d];
					int nextCol = now.col + dc[d];
					int nextStatus = now.status;
					
					// 도착지점을 발견하면 끝낸다.
					if (map[nextRow][nextCol] == '1') {
						System.out.println(moveCount);
						return;
					}
					
					// 열쇠를 발견하면 비트 연산으로 열쇠 보유 상태를 만들어준다.
					if ('a' <= map[nextRow][nextCol] && map[nextRow][nextCol] <= 'f') {
						/**
						 * map[nextRow][nextCol] - 'a'는
						 * 'a' => 0,
						 * 'b' => 1,
						 * ...
						 * 'f' => 5 로 만들어주는 코드다.
						 * 1 << (0~5)의 경우
						 * 열쇠 a는 000001 (1)
						 * 열쇠 b는 000010 (2)
						 * ...
						 * 열쇠 f는 100000 (16) 으로 만들겠다는 것이다.
						 * 
						 * |= 는 비트연산 or와 대입연산 =의 묶음이다.
						 * 
						 * 만약 원래 상태가 110101인데
						 * 열쇠 b를 만나서 000010과 |=연산을 하게 되면 110111로 열쇠 b에 대한 획득정보가 추가된다.
						 * 원래 상태가 110011처럼 열쇠 b를 갖고 있었다 쳐도 110011로 그대로 유지되어 열쇠 b를 갖고있다는 정보는 유지된다.
						 */
						nextStatus |= (1 << (map[nextRow][nextCol] - 'a'));
					}
					
					// 해당 상태로 방문한 적이 있으면 넘어감
					if (visitStatus[nextRow][nextCol][nextStatus]) continue;
					// 방문 상태를 저장한다.
					visitStatus[nextRow][nextCol][nextStatus] = true;
					
					// 문을 발견하면 비트 연산으로 열쇠 보유 상태를 확인한다.
					if ('A' <= map[nextRow][nextCol] && map[nextRow][nextCol] <= 'F') {
						/**
						 * (1 << (map[nextRow][nextCol] - 'A')) 까지는 위의 열쇠처리와 동일한 개념으로 보면 되고
						 * nextStatus와의 비트 and연산(&)을 한다.
						 * C문에 왔다고 가정하면
						 * (1 << (map[nextRow][nextCol] - 'A'))는 000100이 될 것이다.
						 * 이 때 nextStatus가
						 * 101011 처럼 열쇠 C를 가지지 못한 상태라면
						 * 000100과의 비트 and 연산의 결과가 0이 나온다. 이는 열쇠가 없다는 뜻이므로 continue로 넘어간다.
						 * 하지만 nextStatus가
						 * 100100 처럼 열쇠 C를 가지고 있는 상태라면
						 * 000100과의 비트 and 연산의 결과가 100(4)가 나온다. 이는 열쇠가 있다는 뜻이므로 방문할 수 있다는 소리이므로 계속 진행한다.
						 */
						if ((nextStatus & (1 << (map[nextRow][nextCol] - 'A'))) == 0) continue;
					}
					
					
					switch(map[nextRow][nextCol]) {
					case 0:
					case '#':
						// 테두리거나 벽이면 못 감
						break;
					default:
						// 나머지 경우(빈 공간, 열쇠, 열쇠를 보유한 문)에 대해서는 다음 이동 횟수에 탐색할 지점에 해당 지점과, 상태를 넣어준다.
						nextQueue.add(new Point(nextRow, nextCol, nextStatus));
						break;
					}
				}
			}
			// while문 종료 시 다음 이동 횟수에 대한 탐색을 하므로 queue를 넘겨준다.
			queue = nextQueue;
		}
		
		// 끝까지 찾지 못했으면 -1을 출력한다.
		System.out.println(-1);
	}
	
}