/*
 * The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for the specific language governing rights and limitations under the License. The
 * Original Code is vox-mail. The Initial Developer of the Original Code is Voxeo Corporation. Portions created by Voxeo
 * are Copyright (C) 2000-2007. All rights reserved. Contributor(s): ICOA Inc. <info@icoa.com> (http://icoa.com)
 */

package org.voxmail.types;

import java.util.ArrayList;
import java.util.Iterator;

public class Contacts {

    private final ArrayList<Contact> contacts;

    public Contacts() {
        this.contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void addContact(final Contact contact) {
        this.contacts.add(contact);
    }

    public void updateContact(final Contact contact) {
        this.removeContact(contact.getContactID());
        this.contacts.add(contact);
    }

    public void removeContact(final int contactID) {
        Iterator<Contact> it = this.contacts.iterator();
        while (it.hasNext()) {
            Contact contact = it.next();
            if (contact.getContactID() == contactID) {
                it.remove();
            }
        }
    }

    public Contact getContact(final int contactID) {
        Iterator<Contact> it = this.contacts.iterator();
        while (it.hasNext()) {
            Contact contact = it.next();
            if (contact.getContactID() == contactID) {
                return contact;
            }
        }
        return null;
    }

    public Contact getContact(final String phoneNumber, final String pin) {
        Iterator<Contact> it = this.contacts.iterator();

        while (it.hasNext()) {
            Contact contact = it.next();
            if ((contact.getPhoneNumber() == null) || (contact.getPin() == null)) {
                return null;
            }
            if (contact.getPhoneNumber().equals(phoneNumber) && contact.getPin().equals(pin)) {
                return contact;
            }
        }
        return null;
    }

}
