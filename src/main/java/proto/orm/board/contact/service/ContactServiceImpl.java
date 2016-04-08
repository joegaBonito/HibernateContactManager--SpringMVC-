package proto.orm.board.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proto.orm.board.contact.dao.ContactDAO;
import proto.orm.board.contact.domain.Contact;

@Transactional
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    public void removeContact(int id) {
        contactDAO.removeContact(id);
    }
}
