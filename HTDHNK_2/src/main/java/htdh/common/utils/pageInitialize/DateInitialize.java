package htdh.common.utils.pageInitialize;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
public class DateInitialize {

    public static ObservableList<Integer> createRange(int start, int end){
        ObservableList<Integer> range = FXCollections.observableArrayList();
        for (int i=start;i<=end;i++){
            range.add(i);
        }
        return range;
    }

    public static ObservableList<Integer> initYear(){
        return createRange(2023,2028);
    }

    public static ObservableList<Integer> initMonth(){
        return createRange(1,12);
    }

    public static ObservableList<Integer> initDays(){
        return createRange(1,31);
    }
}