package ru.otus.askurkin.lesn16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

	Map<String, HashSet<String>> phoneList = new HashMap<>();

	public void add(String name, String phone) {
		HashSet<String> phones = phoneList.get(name);
		if (phones == null) {
			phones = new HashSet<>();
		}
		phones.add(phone);
		phoneList.put(name, phones);
	}

	public Set<String> find(String name) {
		return phoneList.get(name);
	}

	public boolean containsPhoneNumber(String checkedPhone) {
		for (String name : phoneList.keySet()) {
			for (String phone : phoneList.get(name)) {
				if (checkedPhone.equals(phone)) {
					return true;
				}
			}
		}
		return false;
	}

}
