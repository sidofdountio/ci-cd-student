package com.sidof.schoolapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


class SchoolApplicationTests {

	@Test
	void shouldCheckIfCorrect() {
//		given
		int numberOne =1_500_000;
		int numberTwo=900_000;
//		when
		int result = numberOne + numberTwo;
//		then
		int expected = 2_400_000;
		assertThat(result).isEqualTo(expected);
	}

}

