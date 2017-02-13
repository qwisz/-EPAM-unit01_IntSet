package com.epam.java.se;

import java.util.Arrays;

/**
 * Created by Anton on 12.02.2017.
 */
public class Notepad {

    class Note {
        String str;

        public Note() {
            this.str = "";
        }

        public Note(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return this.str;
        }
    }

    private Note[] notes;
    private int size;
    private int capacity;

    public Notepad() {
        this.notes = new Note[10];
        this.size = 0;
        this.capacity = 10;
    }

    public Notepad(int n) {
        this.notes = new Note[n];
        this.size = 0;
        this.capacity = n;
    }

    /**
     *
     * @param note добавляемая запись
     */
    public void addNote(String note) {
        if (size == capacity)
            grow();
        notes[size] = new Note(note);
        size += 1;
    }

    /**
     *
     * @param n номер удаляемой записи
     */
    public void deleteNote(int n) {
        if (n < 0 || n >= size)
            System.out.println("Записи с таким номером нет");
        else {
            notes[n] = null;
            size -= 1;
        }
    }

    /**
     *
     * @param n номер редактируемой записи
     * @param newNote новая запись
     */
    public void editNote(int n, String newNote) {
        if (n < 0 || n >= size)
            System.out.println("Записи с таким номером нет");
        else {
            notes[n] = new Note(newNote);
        }
    }

    public void printNotes() {
        for (int i = 0; i < size + 1; i++) {
            if (notes[i] != null)
                System.out.println(notes[i]);
        }
    }

    /**
     * Если массив заполнился,
     * то увеличиваем его размер в полтора раза
     */
    private void grow() {
        int newCapacity = (int)(capacity * 1.5);
        notes = Arrays.copyOf(notes, newCapacity);
        capacity = newCapacity;
    }
}
