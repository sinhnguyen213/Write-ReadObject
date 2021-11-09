package com.luvina.chiahaiso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + "_" + name;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		List<Person> list1 = new ArrayList<Person>();
		List<Person> list2 = new ArrayList<Person>();

		Person p1 = new Person(1, "Sinh");
		Person p2 = new Person(2, "Huyen");

		list1.add(p1);
		list1.add(p2);
		System.out.println(list1);
		System.out.println(list2);
		File file = new File("writeObj.txt");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Write object to file	
		FileOutputStream fileOutputStream = new FileOutputStream(file);

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(p1);
		objectOutputStream.writeObject(p2);

		
		//read object from file
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

//		Person person = (Person)objectInputStream.readObject();
//		System.out.println(person);

		boolean cont = true;
		while (cont) {

			try {

				Person person = person = (Person) objectInputStream.readObject();
				list2.add(person);
			} catch (Exception e) {
				cont = false;
			}
		}

		System.out.println(list2);

	}

}
