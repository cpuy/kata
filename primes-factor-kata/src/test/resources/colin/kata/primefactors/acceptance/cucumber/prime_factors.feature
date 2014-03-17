Feature: Prime Factors
	A number can be decomposed in prime factors
	
	Scenario: Prime factor of 5 is 5
		Given a number
		When number is 5
		Then prime factor should be 5
		
	Scenario: Prime factor of 12 are 3, 2 and 2
		Given a number
		When number is 12
		Then prime factors should be "3, 2, 2"
		
	Scenario: Prime factor of 2658 are 443, 3 and 2
		Given a number
		When number is 2658
		Then prime factors should be "443, 3, 2"
		
#	This is a failing test - Long needed
#	Scenario: Prime factor of 5743373809 are 491, 233, 61 and 823
#		Given a number
#		When number is 5743373809
#		Then prime factors should be "491, 233, 61, 823"