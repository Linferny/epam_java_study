package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mark <T extends Number & Comparable<? super T>> {
    T value;
    Date date;

    public int compare(T val){
        return value.compareTo(val);
    }
}
