package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    String name;
    String surname;
    String patronymic;

    public void generateRandom() {
        Random rand = new Random();
        String[] namesM = {"Sergey", "Oleg", "Georgiy", "Alexander", "Viktor", "Pavel", "Egor"};
        String[] namesF = {"Marina", "Natasha", "Victoria", "Alexandra", "Olga"};
        String[] surnames = {"Vorobyshev", "Evdokimov", "Beketov", "Gabiulin", "Razumov"};
        String[] patronymics = {"Sergeev", "Olegov", "Pavlov"};

        if (rand.nextInt(2) == 0) {
            name = namesM[rand.nextInt(namesM.length)];
            surname = surnames[rand.nextInt(surnames.length)];
            patronymic = patronymics[rand.nextInt(patronymics.length)] + "ich";
        } else {
            name = namesF[rand.nextInt(namesF.length)];
            surname = surnames[rand.nextInt(surnames.length)] + "a";
            patronymic = patronymics[rand.nextInt(patronymics.length)] + "na";
        }
    }
}
