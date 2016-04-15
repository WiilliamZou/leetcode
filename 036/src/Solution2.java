/**
 * Created by yunxiaozou on 4/15/16.
 */
import java.util.HashSet;
    import java.util.Set;

    public class Solution2 {
        public Set<Character> set=new HashSet<Character>();
        public boolean isValidSudoku(char[][] board) {
            for(int i=0;i<9;i++){
                if(!validPartial(board,i,i,0,8)) return false;
                if(!validPartial(board,0,8,i,i)) return false;
            }
            for(int i=0;i<9;i+=3){
                for(int j=0;j<9;j+=3){
                    if(!validPartial(board,i,i+2,j,j+2)) return false;
                }
            }
            return true;
        }
        public boolean validPartial(char[][] board,int row1,int row2,int col1,int col2){
            set.clear();
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++){
                    if(board[i][j]!='.') {
                        if(!set.add(board[i][j])) return false;
                    }
                }
            }
            return true;
        }
}
