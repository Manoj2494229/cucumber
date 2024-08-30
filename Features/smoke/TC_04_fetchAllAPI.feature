Feature: Fetch ALL API and check status code and response time

	@api_regression
	Scenario: Fetch ALL API and check status code.
	When hit api
	And check status response 

	