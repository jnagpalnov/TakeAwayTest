Feature: MovieDataBaseList
  Background: Creates a list before every test scenario
    Given User has set the Request Base URI
    When User makes a request for creating a list
      |name|iso_639_1|
      |My Cool List all tests|en|
    Then Verify list creation request was successful and verify the response body

  Scenario: Update List
    When User updates the list
     |name |description|public|
     |My Cool List Updated|test description added|true|
    Then Verify response status code is 201 and response contains "The item/record was updated successfully." success message
    And Verify get list request response
      |name |description|public|iso_639_1|iso_3166_1|
      |My Cool List Updated|test description added|true|en|US|

  Scenario: Add items, update items and remove items from the created list
    When User add items to the list
      |media_type |media_id|
      |movie|550|
      |movie|244786|
    Then Verify response status code is 200 and verify the response body
    And User update the list items
      |media_type |media_id|comment|
      |movie|550|Amazing Action Movie|
      |movie|244786|Wow|
    Then Verify response status code is 200 and verify the response body
    And User remove list items
      |media_type |media_id|
      |movie|244786|
    Then Verify response status code is 200 and verify the response body

  Scenario: Clear the created list
    When User add items to the list
      |media_type |media_id|
      |movie|194662|
      |movie|76203|
    Then Verify response status code is 200 and verify the response body
    And User makes a request for clearing all of the items from the list
    Then Verify the clear list request response code is 200 and then verify the response body


  Scenario: Verify error while creating and updating list without mandatory parameters
    When User makes a request for creating a list
      |name|
      |My Cool List all testsen|
    Then Verify invalid create request response status code is 422 and response contains "iso_639_1 must be provided" error message
    And User makes a request for creating a list
      |iso_639_1|
      |invalid|
    Then Verify invalid create request response status code is 422 and response contains "name must be provided" error message

#  Scenario: Verify error while removing list item that doesn't exists.
#    And User remove list items
#      |media_type |media_id|
#      |invalid|244786|
#    Then Verify response status code is 200 and verify the response body

  Scenario: Verify unauthorized error while creating and updating list without proper authorization.
    When User makes unauthorized list request
      |media_type |media_id|
      |movie|194662|
      |movie|76203|
    Then Verify unauthorized create request response status code is 401 and response contains "You must specify an Authorization header with a Bearer token to proceed." error message

#
#  Scenario: Verify error while trying to clearing or deleting a list that doesn't exists.
#    When User add items to the list
#      |media_type |media_id|
#      |movie|194662|
#      |movie|76203|
#    Then Verify response status code is 200 and verify the response body
#    And User make request for clearing all of the items from the list
#    Then Verify the clear list request response










