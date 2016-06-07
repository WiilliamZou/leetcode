import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        recurse(res, word, 0);
        return res;
    }
    private void recurse(List<String> res, String word, int pos){
        if(pos==word.length()){
            res.add(word);
            return;
        }
        /* The current position does not abbreviate to 1 and call the recursion with the next position */

        recurse(res, word, pos+1);
        String nstring = word.substring(0,pos)+"1"+word.substring(pos+1);

      /* Abbreviate the current position and we have to check the position prior to this position.
       If the position prior to this position is a number, we have to combine them together. 
      But there is still a little tricky to deal with the output because if the combined output is 
      those 9, 99, 999, then the next position should be pos+1 with recursion call. If not,
     the next position should remain the same pos. */

        if(pos>0 && Character.isDigit(word.charAt(pos-1))){
            int count = 0;

           /*count the prior characters which is digits and we should combine them with 1 */

            while((pos-count-1)>=0 && Character.isDigit(word.charAt(pos-count-1))){
                count++;
            }
            int num = Integer.parseInt(word.substring(pos-count, pos));
            num = num+1;
            String nnum = num+"";
            if(nnum.length()>count){
                nstring = word.substring(0, pos-count)+nnum+word.substring(pos+1);
                recurse(res, nstring, pos+1);
            }else{
                nstring = word.substring(0, pos-count)+nnum+word.substring(pos+1);
                recurse(res, nstring, pos);
            }
        }else{
            recurse(res, nstring, pos+1);
        }
    }
}