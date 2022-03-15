package com.blz.program;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * @author - Priya
 * Purpose to add the details of the person using collection
 */
public class AddressBook {
	Set<Person> list = new HashSet<>();
	// As we use hashSet here multiple entries are not allowed.
	Scanner sc;

//    To add the new contacts or details to address book
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Address Book Porgram");
		AddressBook addressBook = new AddressBook();

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 10) {
			System.out.print("please choose from below\n1-add contact\n2-edit contact\n:-> ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addressBook.addDetails();
				break;
			case 2:
				addressBook.editContact();
				break;
			}
		}
	}

}
