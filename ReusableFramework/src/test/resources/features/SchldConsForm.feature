Feature: Verify Nursing logic for Schedule Consultation (IRF Short) form in Capella Home Page Header Menu
	In order to verify Nursing logic for Schedule Consultation (IRF Short) form in Capella Home Page Header Menu works as expected, we will do acceptance testing

Scenario: Verify Nursing logic for Schedule Consultation (IRF Short) form in Capella Home Page Header Menu 

	Given I am on the Capella Home page "https://www.capella.edu/"
	And "ASK A QUESTION" Menu link available on Home Page Header
	When I click on ask a question menu
	Then I should see the "Schedule Consultation" link under the menu
	When I click on ask a schedule consultation link
	Then I should see the schedule consultation modal pop up form
	When I select "Certificate" as Degree
	And "Nursing" as Area of Study in form
	Then I should see unrestricted RN license question provided to user