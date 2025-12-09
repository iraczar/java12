package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    @Test
    void shouldAddMovie() {
        AfishaManager manager = new AfishaManager();
        Movie movie = new Movie(1, "Бладшот", "боевик");

        manager.add(movie);

        Movie[] all = manager.findAll();
        assertEquals(1, all.length);
        assertEquals(movie, all[0]);
    }

    @Test
    void shouldFindAllMoviesInOrder() {
        AfishaManager manager = new AfishaManager();
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");
        Movie movie3 = new Movie(3, "Отель Белград", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] all = manager.findAll();
        assertEquals(3, all.length);
        assertEquals(movie1, all[0]);
        assertEquals(movie2, all[1]);
        assertEquals(movie3, all[2]);
    }

    @Test
    void shouldFindLast5MoviesDefaultLimit() {
        AfishaManager manager = new AfishaManager();
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");
        Movie movie3 = new Movie(3, "Отель Белград", "комедия");
        Movie movie4 = new Movie(4, "Джентльмены", "боевик");
        Movie movie5 = new Movie(5, "Человек-невидимка", "ужасы");
        Movie movie6 = new Movie(6, "Тролли", "мультфильм");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        Movie[] last = manager.findLast();

        assertEquals(5, last.length);
        assertEquals(movie6, last[0]);
        assertEquals(movie5, last[1]);
        assertEquals(movie4, last[2]);
        assertEquals(movie3, last[3]);
        assertEquals(movie2, last[4]);
    }

    @Test
    void shouldFindLast3MoviesCustomLimit() {
        AfishaManager manager = new AfishaManager(3);
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");
        Movie movie3 = new Movie(3, "Отель Белград", "комедия");
        Movie movie4 = new Movie(4, "Джентльмены", "боевик");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        Movie[] last = manager.findLast();

        assertEquals(3, last.length);
        assertEquals(movie4, last[0]);
        assertEquals(movie3, last[1]);
        assertEquals(movie2, last[2]);
    }

    @Test
    void shouldFindAllMoviesWhenLessThanLimit() {
        AfishaManager manager = new AfishaManager(5);
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");

        manager.add(movie1);
        manager.add(movie2);

        Movie[] last = manager.findLast();

        assertEquals(2, last.length);
        assertEquals(movie2, last[0]);
        assertEquals(movie1, last[1]);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        AfishaManager manager = new AfishaManager();

        Movie[] all = manager.findAll();
        Movie[] last = manager.findLast();

        assertEquals(0, all.length);
        assertEquals(0, last.length);
    }

    @Test
    void shouldFindExactLimitWhenMoviesEqualLimit() {
        AfishaManager manager = new AfishaManager(3);
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");
        Movie movie3 = new Movie(3, "Отель Белград", "комедия");

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] last = manager.findLast();

        assertEquals(3, last.length);
        assertEquals(movie3, last[0]);
        assertEquals(movie2, last[1]);
        assertEquals(movie1, last[2]);
    }
}