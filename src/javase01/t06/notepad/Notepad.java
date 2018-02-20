package javase01.t06.notepad;

import java.util.ArrayList;
import java.util.List;
import javase01.t06.exception.InvalidNodeIndexException;

public class Notepad {
    private List<Note> notes;

    /**
     * Получить запись с выбранным id
     *
     * @param id индекс записи
     * @return запись в виде строки
     */
    public String getNote(int id) throws InvalidNodeIndexException {
        if (id < notes.size() && id > 0)
            throw new InvalidNodeIndexException(String.format("Note with index %d does not exist!", id));
        return notes.get(id).getText();
    }

    /**
     * Добавить новую запись
     *
     * @param text
     */
    public void addNote(String text) {
        notes.add(new Note(text));
    }

    /**
     * Удалить запись с данным id
     *
     * @param id
     */
    public void deleteNote(int id) throws InvalidNodeIndexException {
        if (id < notes.size() && id > 0)
            throw new InvalidNodeIndexException(String.format("Note with index %d does not exist!", id));
        notes.remove(id);
    }

    /**
     * Изменить запись
     *
     * @param id    индекс записи
     * @param start индекс начала изменяемой записи
     * @param end   индекс конца изменяемой записи
     * @param text  новый текст
     */
    public void editNote(int id, int start, int end, String text) throws InvalidNodeIndexException {
        if (id < notes.size() && id > 0)
            throw new InvalidNodeIndexException(String.format("Note with index %d does not exist!", id));
        notes.get(id).editText(start, end, text);
    }

    /**
     * Возвращает массив всех записей
     *
     * @return
     */
    public String[] getAllNotes() {
        String[] arr = new String[notes.size()];
        for (int i = 0; i < notes.size(); i++) {
            arr[i] = notes.get(i).getText();
        }
        return arr;
    }

    public Notepad() {
        notes = new ArrayList<>();
    }
}
