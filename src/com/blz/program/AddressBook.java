package com.blz.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
 * @author - Priya
 * Purpose to add the details of the person using collection
 */
public class AddressBook {
	static AddressBook addressBook = new AddressBook();

	ArrayList<Person> list = new ArrayList();
	// As we use hashSet here multiple entries are not allowed.
	Scanner sc;

	static HashMap<String, ArrayList<Person>> contacts = new HashMap<>();

//	    To add the new contacts or details to address book
	public void addDetails() {
		sc = new Scanner(System.in);

		System.out.print("Enter first name :: ");
		String firstName = sc.next();

		System.out.print("Enter last name :: ");
		String lastName = sc.next();

		System.out.print("Enter your address :: ");
		String address = sc.next();

		System.out.print("Enter your city :: ");
		String city = sc.next();

		System.out.print("Enter zip code :: ");
		String zipCode = sc.next();

		System.out.print("Enter phone number :: ");
		String phoneNumber = sc.next();

		System.out.print("Enter email :: ");
		String email = sc.next();

//	        We add multiple person's details using hashSet
		list.add(new Person(firstName, lastName, address, city, zipCode, phoneNumber, email));

		System.out.println(list);
	}

	private void editContact() {
		System.out.print("Enter person name to edit person :: ");
		String editPersonName = sc.next();
		Person person = getPerson(editPersonName);
		System.out.print(
				"Enter what you want to edit :: 1-first name\n2-lastname\n3-address\n4-city\n5-zip code\n6-phone number\n7-email\n::-> ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			editFirstName(person);
			break;
		case 2:
			editLastName(person);
			break;
		case 3:
			editAddress(person);
			break;
		case 4:
			editCity(person);
			break;
		case 5:
			editZipCode(person);
			break;
		case 6:
			editPhoneNumber(person);
			break;
		case 7:
			editEmail(person);
			break;
		default:
			System.out.println("Enter valid choice :");
		}

		System.out.println(list);
	}

	private void editEmail(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new email here :-> ");
		person.email = sc.next();
	}

	private void editPhoneNumber(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new phone number here :-> ");
		person.phoneNumber = sc.next();
		System.out.println("Done");

	}

	private void editZipCode(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new zip code here :-> ");
		person.zipCode = sc.next();
		System.out.println("Done");

	}

	private void editCity(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new city name :: ");
		person.city = sc.next();
		System.out.println("Done");

	}

	private void editAddress(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new address here :-> ");
		person.address = sc.next();
		System.out.println("Done");

	}

	private void editLastName(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new last name here :->");
		person.lastName = sc.next();
		System.out.println("Done");
	}

	private void editFirstName(Person person) {
		sc = new Scanner(System.in);
		System.out.print("Enter new First name here  :->");
		person.firstName = sc.next();
		System.out.println("Done");

	}

	private Person getPerson(String editPersonName) {
		Iterator iterator = list.iterator();
		if (iterator.hasNext()) {
			for (int i = 0; i < list.size(); i++) {
				Person person = (Person) iterator.next();
				if (person.firstName.equalsIgnoreCase(editPersonName)) {
					return person;
				}
			}
		}
		return null;
	}

	private void deletePerson() {
		sc = new Scanner(System.in);
		System.out.print("Enter name of person to delete its contact :-> ");
		String personName = sc.next();
		Person person = getPerson(personName);
		if (person == null) {
			System.out.println(":: sorry No person found for given name ::");
		} else {
			list.remove(person);
		}

	}

	public void createAddressBook() {

		while (true) {
			System.out.println("Choose what you want to do: ");
			System.out.println(
					"1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
			int choose = sc.nextInt();

			if (choose == 4) {
				System.out.println("Exited");
				break;
			}

			switch (choose) {
			case 1:
				System.out.println("Enter the name of address book: ");
				String address_name = sc.next();

				// condition to check for uniqueness of address book.
				if (contacts.containsKey(address_name)) {
					System.out.println("Adress book name exits, enter different name");
					break;
				}

				ArrayList<Person> new_address_book = new ArrayList<>();
				list = new_address_book;
				while (true) {
					int choose1;
					System.out.println("Choose what you want to do: ");
					System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
					choose1 = sc.nextInt();
					if (choose1 == 4) {
						System.out.println("Exited");
						break;
					}
					switch (choose1) {
					case 1:
						addressBook.addDetails();
						break;
					case 2:
						addressBook.editContact();
						break;
					case 3:
						addressBook.deletePerson();
						break;
					default:
						System.out.println("Choose valid option");
						break;
					}
					contacts.put(address_name, list);
					System.out.println(contacts);
				}
				break;

			case 2:
				System.out.println("Enter the name of address book: ");
				String address_name_old = sc.next();

				// condition to check whether address book exists or no.
				if (contacts.containsKey(address_name_old)) {

					ArrayList<Person> old_address_book = new ArrayList<>();
					list = old_address_book;
					list = contacts.get(address_name_old);
					while (true) {
						System.out.println("Choose what you want to do: ");
						System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
						int choose2 = sc.nextInt();
						if (choose2 == 4) {
							System.out.println("Exited");
							break;
						}
						switch (choose2) {
						case 1:
							addressBook.addDetails();
							break;
						case 2:
							addressBook.editContact();
							break;
						case 3:
							addressBook.deletePerson();
							break;
						default:
							System.out.println("Choose valid option");
							break;
						}
						contacts.put(address_name_old, list);
						System.out.println(contacts);
					}
				} else {
					System.out.println("Enter valid address book name");
				}
				break;

			case 3:
				System.out.println(contacts);
				break;

			default:
				System.out.println("Enter valid option");

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Address Book Porgram");
		addressBook.createAddressBook();
	}

}