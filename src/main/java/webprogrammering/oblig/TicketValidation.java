package webprogrammering.oblig;

public class TicketValidation {
    public static void validateTicket(Ticket ticket) throws IllegalArgumentException {
        validateAttribute(ticket.getFilm());
        validateAttribute(ticket.getName());
        validateAttribute(ticket.getSurname());
        validateAttribute(ticket.getPhone());
        validateAttribute(ticket.getEmail());
    }

    private static void validateAttribute(String attribute) {
        if(!attribute.matches("[\\w'\\ \"\\-øæåØÆÅ.,()_@]{1,60}")) {
            throw new IllegalArgumentException("Ugyldig tegn");
        }

    }
}
