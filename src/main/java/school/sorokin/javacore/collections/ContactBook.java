package school.sorokin.javacore.collections;

import java.util.*;


public class ContactBook {
    private final List<Contact> contactsList = new ArrayList<>();
    private final Set<Contact> contactsSet = new HashSet<>();
    private final Map<String, List<Contact>> contactsGroup = new HashMap<>();


    public boolean add(Contact contact) {
        if (!contactsSet.add(contact)) {
            return false;
        }

        contactsList.add(contact);

        List<Contact> groupList = contactsGroup.get(contact.getGroup());
        if (groupList == null) {
            groupList = new ArrayList<>();
            contactsGroup.put(contact.getGroup(), groupList);
        }
        groupList.add(contact);

        return true;
    }

    public boolean remove(String name, String phone) {
        Contact tempContact = new Contact(name, phone, "", "");

        if (!contactsSet.remove(tempContact)) {
            return false;
        }

        for (Iterator<Contact> it = contactsList.iterator(); it.hasNext(); ) {
            Contact c = it.next();

            if (c.getName().equals(name) && c.getPhone().equals(phone)) {
                it.remove();
                break;
            }
        }

        for (Map.Entry<String, List<Contact>> entry : contactsGroup.entrySet()) {
            List<Contact> groupContacts = entry.getValue();
            for (Iterator<Contact> it = groupContacts.iterator(); it.hasNext(); ) {
                Contact c = it.next();
                if (c.getName().equals(name) && c.getPhone().equals(phone)) {
                    it.remove();
                    break;
                }
            }
        }

        return true;
    }

    public void printAll() {
        if (contactsList.isEmpty()) {
            System.out.println("Список контактов пуст.");
            return;
        }

        for (Contact contact : contactsList) {
            System.out.println(contact);
        }
    }

    public List<Contact> findByName(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contactsList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                result.add(contact);
            }
        }
        return result;
    }

    public Contact findByPhone(String phone) {
        for (Contact contact : contactsList) {
            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    public void printByGroup(String group) {
        List<Contact> contacts = contactsGroup.get(group);
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("Группа пустая.");
            return;
        }

        System.out.println(" Контакты в группе \"" + group + "\": ");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}