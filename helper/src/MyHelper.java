


/**
 * Created by yunxiaozou on 4/12/16.
 */
public class MyHelper {
    public static <S, T extends Iterable<S>> void printCollection(T list) {
        for (S element : list){
            System.out.println(element.toString());
        }
    }
}
