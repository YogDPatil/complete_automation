package com.runner;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.github.javafaker.Faker;
import com.utils.TestUtils;

public class Run {

	public static void main(String[] args) {
//		Faker faker = new Faker();
//		System.out.println(faker.number());
//		System.out.println(faker.numerify("###"));

		Map<String, String> data = TestUtils.getFakeData();
		
		System.out.println(data.get("FirstName"));
		
	}

}
