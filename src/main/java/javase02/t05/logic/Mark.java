package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Accessors(chain = true)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mark <T extends Number & Comparable<? super T>> {
    T value;
    LocalDateTime date;

    public Mark() {
    }

    public int compare(T val){
        return value.compareTo(val);
    }


    public T getValue() {
        return this.value;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Mark<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public Mark<T> setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Mark)) return false;
        final Mark other = (Mark) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Mark;
    }

    public String toString() {
        return value.toString();
    }
}
