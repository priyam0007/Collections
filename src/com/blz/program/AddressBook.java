package com.blz.program;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
	Set<Person> list = new HashSet<>();
	// as we use hashSet here multiple entries are not allowed.
	Scanner sc;

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

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Porgram");

		AddressBook addressBook = new AddressBook();
		addressBook.addDetails();
	}

}
