package a0406;

import java.io.IOException;
import java.util.HashSet;

public class P_방문길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution("ULURRDLLU") + "");
		
	}
	public static int solution(String dirs) {
        int x=0, y=0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<dirs.length();i++) {
        	char c = dirs.charAt(i);
        	int nx=x;
        	int ny=y;
        	switch(c) {
        		case 'U':
        			if(x-1<-5) break;
        			nx=x-1;break;
        		case 'D':
        			if(x+1>5) break;
        			nx=x+1;break;
        		case 'R':
        			if(y+1>5) break;
        			ny=y+1;break;
        		case 'L':
        			if(y-1<-5) break;
        			ny=y-1;break;
        	}
        	if(x!=nx) {
        		set.add(x +""+ nx+"" + ""+y +""+ y);
    			set.add(nx +""+ x+"" + ""+y +""+ y);
    			x=nx;
        	}else if(y!=ny){
        		set.add(x +""+ x+"" + ""+y +""+ ny);
    			set.add(x +""+ x+"" + ""+ny +""+ y);
    			y=ny;
        	}
        	
        }
        return set.size()/2;
    }
}
