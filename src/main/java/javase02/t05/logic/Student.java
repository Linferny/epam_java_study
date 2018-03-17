package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    String name;
    String surname;
    String patronymic;
}
