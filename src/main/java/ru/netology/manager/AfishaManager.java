package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    // Конструктор по умолчанию с лимитом 5
    public AfishaManager() {
        this.limit = 5;
    }

    // Конструктор с параметром для настройки лимита
    public AfishaManager(int limit) {
        this.limit = limit;
    }

    // Добавление нового фильма
    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    // Вывод всех фильмов в порядке добавления
    public Movie[] findAll() {
        return movies;
    }

    // Вывод последних добавленных фильмов в обратном порядке
    public Movie[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}