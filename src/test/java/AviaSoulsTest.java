import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static java.util.Arrays.compare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaSoulsTest {

    @Test
    void testSortFewTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12);
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14);
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9);
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10);
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 15, 10);
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("EKB", "MSK");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket8, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortZeroTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12);
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14);
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9);
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10);
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 15, 10);
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("LA", "MSK");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12);
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14);
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9);
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10);
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 15, 10);
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("UFA", "SPB");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12); //2
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14); //3
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16); //6
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 9); //2
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9); //5
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10); //4
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 5, 10); //5
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("EKB", "MSK", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortZeroTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12); //2
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14); //3
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16); //6
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 9); //2
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9); //5
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10); //4
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 5, 10); //5
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("NEW", "MSK", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("EKB", "MSK", 2000, 10, 12); //2
        Ticket ticket2 = new Ticket("EKB", "MSK", 1000, 11, 14); //3
        Ticket ticket3 = new Ticket("EKB", "SPB", 2000, 10, 16); //6
        Ticket ticket4 = new Ticket("MSK", "EKB", 4000, 7, 9); //2
        Ticket ticket5 = new Ticket("UFA", "SPB", 8000, 4, 9); //5
        Ticket ticket6 = new Ticket("EKB", "MSK", 2000, 6, 10); //4
        Ticket ticket7 = new Ticket("EKB", "MSK", 5000, 5, 10); //5
        Ticket ticket8 = new Ticket("EKB", "MSK", 4000, 7, 8); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("UFA", "SPB", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

}








