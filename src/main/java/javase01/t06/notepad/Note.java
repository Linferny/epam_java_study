package javase01.t06.notepad;

import java.time.LocalDateTime;

public class Note {
    private LocalDateTime time;
    private StringBuilder text;

    /**
     * Возвращает дату создания записи
     *
     * @return
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Возвращает текст записи
     *
     * @return
     */
    public String getText() {
        return text.toString();
    }

    /**
     * Добавляет текст в конец строки
     *
     * @param text
     */
    public void setText(String text) {
        this.text.append(text);
    }

    /**
     * Меняет текст записи на указанном промежутке
     *
     * @param start индекс начала замены
     * @param end индекс конца замены
     * @param text вставляемый текст
     */
    public void editText(int start, int end, String text) {
        if (start > end || start < 0 || end >= this.text.length())
            return;
        this.text.replace(start,end, text);
    }

    public Note() {
        text = new StringBuilder();
        time = LocalDateTime.now();
    }

    public Note(String text){
        this.text = new StringBuilder(text);
        time = LocalDateTime.now();
    }
}
