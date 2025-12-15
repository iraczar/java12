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

        Movie[] expected = {movie1, movie2, movie3};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
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

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
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

        Movie[] expected = {movie4, movie3, movie2};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllMoviesWhenLessThanLimit() {
        AfishaManager manager = new AfishaManager(5);
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");

        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        AfishaManager manager = new AfishaManager();

        Movie[] expectedAll = {};
        Movie[] expectedLast = {};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
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

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldWorkWithZeroLimit() {
        AfishaManager manager = new AfishaManager(0);
        Movie movie1 = new Movie(1, "Бладшот", "боевик");
        Movie movie2 = new Movie(2, "Вперед", "мультфильм");

        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {};
        Movie[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}