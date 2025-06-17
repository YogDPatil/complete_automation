package com.runner;

import com.github.javafaker.Faker;

public class Run {

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.number());
		System.out.println(faker.numerify("###"));

	}

}
