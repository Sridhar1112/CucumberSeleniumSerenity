Feature: Sapient demo API Smoke Test
  
  Demo API Smoke Test Script

  Scenario: user get provider npi data
    And get provider npi "1003000126"
    Given post provider npi "1003000126"
