/**
 * Created by yunxiaozou on 4/21/16.
 */
public class Solution2 {
    public String intToRoman(int num) {
        String data[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1}, base = 0;
        StringBuilder result = new StringBuilder();

        for(int i = 0;i < data.length;i++){
            if((base=num/value[i])!=0){
                while(base--!=0)result.append(data[i]);
                num=num%value[i];
            }
        }
        return result.toString();
    }
}