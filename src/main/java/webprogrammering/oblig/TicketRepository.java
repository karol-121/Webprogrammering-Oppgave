package webprogrammering.oblig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    public JdbcTemplate db;

    public boolean addTicket(Ticket ticket) {
        try {
            String sql = "INSERT INTO Tickets (film, amount, name, surname, phone, email) VALUES(?,?,?,?,?,?)";
            db.update(sql, ticket.getFilm(), ticket.getAmount(), ticket.getName(), ticket.getSurname(), ticket.getPhone(), ticket.getEmail());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Ticket> getAllTickets() {
        String sql = "SELECT * FROM Tickets";
        List<Ticket> list = db.query(sql,new BeanPropertyRowMapper(Ticket.class));
        list.sort(Comparator.comparing(Ticket::getSurname));
        return list;
    }

    public boolean deleteAllTickets() {
        try {
            String sql = "DELETE FROM Tickets";
            db.update(sql);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
