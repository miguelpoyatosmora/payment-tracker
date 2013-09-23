Feature: Sending payments to the tracker

Scenario: Sending payments to the tracker should add money to the current balance
Given there is no money in the current balance
When £100 is paid
Then the balance should be £100