package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void whenAdd() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = ((Cinema3D) cinema).getLst();
        assertThat(sessions.get(0), is(session));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceAlreadyBuy() {
        Cinema cinema = new Cinema3D();
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        cinema.buy(account1, 1, 1, new GregorianCalendar(2022, Calendar.DECEMBER, 1));
        cinema.buy(account2, 1, 1, new GregorianCalendar(2022, Calendar.DECEMBER, 1));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenDateNotExist() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        cinema.buy(account, 1, 1, new GregorianCalendar(1990, Calendar.DECEMBER, 1));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceNotExist() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        cinema.buy(account, 99, -1, new GregorianCalendar(2022, Calendar.DECEMBER, 1));
    }
}