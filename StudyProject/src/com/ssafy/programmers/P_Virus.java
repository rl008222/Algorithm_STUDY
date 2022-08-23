package com.ssafy.programmers;

import java.io.*;
import java.util.*;

public class P_Virus {
   static class Point {
      int row;
      int col;

      public Point(int row, int col) {
         this.row = row;
         this.col = col;
      }
   }

   static class Virus {
      char num;
      int row;
      int col;

      public Virus(char num, int row, int col) {
         this.num = num;
         this.row = row;
         this.col = col;
      }
   }

   // 위, 왼쪽, 아래, 오른쪽
   static int[] dr = { -1, 0, 1, 0 };
   static int[] dc = { 0, -1, 0, 1 };
   // 맵 사이즈
   static int R;
   static int C;
   // 맵
   static char[][] map;
   // 마스크
   static int M;
   // 김싸피 큐
   static Queue<Point> playerQueue;
   // 김싸피가 어디어디 방문했는지
   static boolean[][] playerVisited;
   // 바이러스 큐
   static Queue<Virus> virusQueue;
   // 바이러스가 어느 위치에 얼마나 퍼져있는지 나타냄
   static int[][] virusMap;
   // 바이러스가 어느 위치에 어떤 것이 퍼져있는지 비트로 나타냄
   static int[][] virusVisited;

   // 각종 지형지물들 표시
   static final char SPACE = '*';
   static final char TARGET = 'T';
   static final char PLAYER = 'P';
   static final char WALL = '#';

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int T = Integer.parseInt(br.readLine());
      testCase : for(int tCase = 1; tCase <= T; tCase++) {
         System.out.printf("#%d ", tCase);
         st = new StringTokenizer(br.readLine());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         map = new char[R][C];
         virusMap = new int[R][C];
         virusVisited = new int[R][C];
         playerVisited = new boolean[R][C];
         playerQueue = new LinkedList<>();
         virusQueue = new LinkedList<>();
         M = Integer.parseInt(br.readLine());
         // 입력을 받으며 플레이어 위치를 기록한다.
         int pRow = -1, pCol = -1;
         for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
               map[i][j] = str.charAt(j);
               switch (map[i][j]) {
               case WALL:
               case SPACE:
               case TARGET:
                  // 벽이나 빈 공간, 목표지점은 그대로 넘어가기
                  break;
               case PLAYER:
                  // 플레이어 위치는 빈 칸으로 만듦
                  pRow = i;
                  pCol = j;
                  map[i][j] = SPACE;
                  break;
               default:
                  // 벽도, 빈 공간도, 플레이어 위치도 아니면 바이러스 시작위치
                  virusVisited[i][j] |= 1 << (map[i][j] - '1');
                  virusMap[i][j] += map[i][j] - '0';
                  virusQueue.add(new Virus(map[i][j], i, j));
                  map[i][j] = SPACE;
                  break;
               }
            }
         }
         playerQueue.add(new Point(pRow, pCol));
         playerVisited[pRow][pCol] = true;
         // 플레이어가 갈 곳이 있을 때
         while (!playerQueue.isEmpty()) {
            // 플레이어가 이번 턴에 갈 수 있는 곳 전체를 확인
            int plSize = playerQueue.size();
            for (int p = 0; p < plSize; p++) {
               Point now = playerQueue.poll();
               for (int d = 0; d < 4; d++) {
                  int nextRow = now.row + dr[d];
                  int nextCol = now.col + dc[d];
                  if (!boundaryCheck(nextRow, nextCol)) {
                     // 범위 안 되면 넘김
                     continue;
                  }
                  if (map[nextRow][nextCol] == WALL) {
                     continue;
                  }
                  if (map[nextRow][nextCol] == TARGET) {
                     // 목표 지점 찾으면 끝
                     System.out.println("YES");
                     continue testCase;
                  }
                  if (M < virusMap[nextRow][nextCol]) {
                     // 바이러스 양 더 많으면 못 감
                     continue;
                  }
                  if (playerVisited[nextRow][nextCol]) {
                     // 이미 가본 곳 갈 필요 없음
                     continue;
                  }
                  playerVisited[nextRow][nextCol] = true;
                  playerQueue.add(new Point(nextRow, nextCol));
               }
            }
            // 바이러스 퍼짐
            int vqSize = virusQueue.size();
            for (int v = 0; v < vqSize; v++) {
               Virus virus = virusQueue.poll();
               for (int d = 0; d < 4; d++) {
                  int nextRow = virus.row + dr[d];
                  int nextCol = virus.col + dc[d];
                  if (!boundaryCheck(nextRow, nextCol)) {
                     // 범위 안 되면 넘김
                     continue;
                  }
                  if (map[nextRow][nextCol] == WALL) {
                     continue;
                  }
                  if (map[nextRow][nextCol] == TARGET) {
                     // 목표 지점에는 퍼지지 않음
                     continue;
                  }
                  if ((virusVisited[nextRow][nextCol] & (1 << (virus.num - '1'))) != 0) {
                     // 이미 같은 종류의 바이러스가 지나간 곳에는 바이러스가 가지 않음.
                     continue;
                  }
                  // 해당 지점 바이러스 방문 체크
                  virusVisited[nextRow][nextCol] |= 1 << (virus.num - '1');
                  // 바이러스 퍼짐
                  virusMap[nextRow][nextCol] += virus.num - '0';
                  virusQueue.add(new Virus(virus.num, nextRow, nextCol));
               }
            }
         }
         System.out.println("NO");
      }
   }

   public static boolean boundaryCheck(int row, int col) {
      if (row < 0 || col < 0 || row >= R || col >= C) {
         return false;
      }
      return true;
   }
}