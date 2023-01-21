package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.TicketRepository;
import ru.netology.Ticket;
import ru.netology.TicketManager;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void testSortTicket() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 200, 93);
        Ticket ticket2 = new Ticket(2, "MSK", "SPB", 100, 98);
        Ticket ticket3 = new Ticket(3, "MSK", "UFA", 200, 186);
        Ticket ticket4 = new Ticket(4, "MSK", "SPB", 400, 122);
        Ticket ticket5 = new Ticket(5, "UFA", "SPB", 800, 222);
        Ticket ticket6 = new Ticket(6, "MSK", "SPB", 200, 139);
        Ticket ticket7 = new Ticket(7, "MSK", "LA", 300, 243);
        Ticket ticket8 = new Ticket(8, "MSK", "SPB", 500, 99);

        Assertions.assertEquals(1, ticket1.getId()); // test getID
        Assertions.assertEquals(93, ticket1.getDuration()); // test getDuration

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = manager.findAll("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void test1() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, "MSK", "SPB", 200, 93);

        Assertions.assertEquals(1, ticket1.getId()); // test getID
        Assertions.assertEquals(93, ticket1.getDuration()); // test getDuration

        manager.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, "MSK", "UPB", 200, 93);
        Ticket ticket2 = new Ticket(2, "MSK", "UPB", 100, 98);
        Ticket ticket3 = new Ticket(3, "MSK", "UFA", 200, 186);
        Ticket ticket4 = new Ticket(4, "USA", "SPB", 400, 122);
        Ticket ticket5 = new Ticket(5, "UFA", "SPB", 800, 222);
        Ticket ticket6 = new Ticket(6, "UFA", "SPB", 200, 139);
        Ticket ticket7 = new Ticket(7, "MSK", "LA", 300, 243);
        Ticket ticket8 = new Ticket(8, "LA", "MSK", 500, 99);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] expected = {ticket2,ticket1};
        Ticket[] actual = manager.findAll("MSK", "UPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        Ticket ticket1 = new Ticket(1, "MSK", "UPB", 200, 93);
        Ticket ticket2 = new Ticket(2, "MSK", "UPB", 100, 98);
        Ticket ticket3 = new Ticket(3, "MSK", "UFA", 200, 186);
        Ticket ticket4 = new Ticket(4, "USA", "SPB", 400, 122);
        Ticket ticket5 = new Ticket(5, "UFA", "SPB", 800, 222);
        Ticket ticket6 = new Ticket(6, "UFA", "SPB", 200, 139);
        Ticket ticket7 = new Ticket(7, "MSK", "LA", 300, 243);
        Ticket ticket8 = new Ticket(8, "LA", "MSK", 500, 99);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "ABA");
        Assertions.assertArrayEquals(expected, actual);
    }


}
