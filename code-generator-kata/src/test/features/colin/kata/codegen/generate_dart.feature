Feature: Dart POJO generation
	Scenario: a data structure should be transformed in Dart
		Given a data structure
			"""
			# Domain representation of product 
			D Product
			F id   integer
			F name   text
			F order_code integer
			E
			"""
		When I ask for dart POJO generation
		Then I should have the given POJO
			""" 
			/* Domain representation of product */
			class Product {
			       int id, orderCode;
			       String name;
			       
			      Product(this.id, this.name, this.orderCode);
			}
			"""