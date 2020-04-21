Feature: Launchpad Login
Scenario: Login into Launchpad as Instructor
	Given User is already on login page
	When User enters "G.s.instructor@macmillan.com" and "Password@123"
	And User selects SignIn button    
	Then User is logged in as Instructor
	And User selects the course name
		
Scenario: Verify the TOC of the course
    Given User is on the course page
    When User selects any unit 
    Then All the chapters should appear in content
    |/ContentTestAutomation/src/test/java/com/contentTest/TestData|LMPS.xlsx|Launch Pad|
        
Scenario: Verify the Resources under Content By Type
    Given User has selected Resources tab
    When User selects Content By Type
    Then All the resources should appear as in menuscript
    
    
    
    
 	
	
	
	