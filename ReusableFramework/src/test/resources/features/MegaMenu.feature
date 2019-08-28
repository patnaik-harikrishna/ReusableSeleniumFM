Feature: Acceptance testing to validate Availability of Mega Menus in Capella Home Page 
	In order to validate that the Mega Menus in Capella Home Page are available we will do acceptance testing

Scenario: Validate Availability of Mega Menus in Capella Home Page 

	Given I am on the Home page "https://www.capella.edu/" of Capella Home Page website
	When I move to Degrees & Programs Menu
	Then I should see the "DEGREES + PROGRAMS" text on Degrees & Programs Menu 
	When I move to Capella Experience Menu
	Then I should see "CAPELLA EXPERIENCE" on Capella Experience Menu
	When I move to Financing Menu
	Then I should see "FINANCE" on Capella Financing Menu
	When I move to Apply Menu
	Then I should see "APPLY" on Capella Apply Menu