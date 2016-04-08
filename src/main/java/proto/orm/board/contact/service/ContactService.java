package proto.orm.board.contact.service;

import java.util.List;

import proto.orm.board.contact.domain.Contact;

public interface ContactService {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(int id);
}
