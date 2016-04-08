package proto.orm.board.contact.dao;

import java.util.List;

import proto.orm.board.contact.domain.Contact;

public interface ContactDAO {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(int id);
}
