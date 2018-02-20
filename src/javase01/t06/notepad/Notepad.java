package javase01.t06.notepad;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
    private List<Note> notes;

    /**
     * Получить запись с выбранным id
     * @param id индекс записи
     * @return запись в виде строки
     */
    public String getNote(int id) {
        assert id < notes.size() && id > 0 : String.format("Note with index %d does not exist!", id);
        return notes.get(id).getText();
    }

    /**
     * Добавить новую запись
     * @param text
     */
    public void addNote(String text) {
        notes.add(new Note(text));
    }

    /**
     * Удалить запись с данным id
     * @param id
     */
    public void deleteNote(int id) {
        assert id < notes.size() && id > 0 : String.format("Note with index %d does not exist!", id);
        notes.remove(id);
    }

    /**
     * Изменить запись
     * @param id индекс записи
     * @param start индекс начала изменяемой записи
     * @param end индекс конца изменяемой записи
     * @param text новый текст
     */
    public void editNote(int id, int start, int end, String text) {
        assert id < notes.size() && id > 0 : String.format("Note with index %d does not exist!", id);
        notes.get(id).editText(start, end, text);
    }

    /**
     * Возвращает массив всех записей
     * @return
     */
    public String[] getAllNotes() {
        String[] arr = new String[notes.size()];
        return notes.toArray(arr);
    }

    public Notepad(){
        notes = new ArrayList<>();
    }
}
