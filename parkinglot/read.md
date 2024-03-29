# Parking Lot (Low-Level Design)

## Problem definition
A parking lot is a designated area for parking vehicles and is a feature found in almost all popular venues such as shopping malls, sports stadiums, offices, etc.
In a parking lot, there are different parking spots available for different types of vehicles. Each of these spots is charged according to the time the vehicle has been parked in the parking lot. The parking time is tracked with a parking ticket issued to the vehicle at the entrance of the parking lot. Once the vehicle is ready to exit, it can pay at the exit gate using a card, card, or UPI payment method.

## Requirements
- The parking Lot should have multiple floors
- The parking Lot should have multiple entry and exit gates
- It should support parking of multiple vehicles- two, four, heavy
- Ticket must be generated at the entry gate
- Payment should be done at the exit gate through different modes- cash, card, UPI
- Payment can be done on an hourly or minute basis.
- Parking Space must be allocated close to the entrance gate of the vehicle

## Objects Required
- Vehicle
- Parking Lot
- Floor
- Parking Space- two-wheeler, four-wheeler, heavy-vehicle
- Entry Gate
- Exit Gate
- GateManager
- Ticket
- Payment
- Payment Strategy
