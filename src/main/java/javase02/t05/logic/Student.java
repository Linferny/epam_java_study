package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    String name;
    String surname;
    String patronymic;

    public Student() {
    }

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

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$patronymic = this.getPatronymic();
        final Object other$patronymic = other.getPatronymic();
        if (this$patronymic == null ? other$patronymic != null : !this$patronymic.equals(other$patronymic))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $patronymic = this.getPatronymic();
        result = result * PRIME + ($patronymic == null ? 43 : $patronymic.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Student;
    }

    @Override
    public String toString() {
        return this.getSurname() + " " + this.getName() + " " + this.getPatronymic();
    }
}
