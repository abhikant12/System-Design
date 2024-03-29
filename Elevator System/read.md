# Problem Definition
Elevators are an essential component of many buildings, especially those with multiple floors or high-rise structures, where stairs may not be a practical option. The objective of an elevator system is to provide an alternative means of vertical transportation that is convenient, accessible, and safe for all building occupants.

## Requirements
- There can be multiple floors
- There can be more than one elevator
- Elevators can be added or removed(for maintenance) as needed.
- Two types of requests to be considered-
- - i. Person on the floor pressing the UP/DOWN button to call the elevator
- - ii. Person in the elevator pressing the floor number button to reach a destination
- The algorithm for calling the elevator should be dynamic.
- The functional algorithm for the elevator should also be dynamic

## Objects
- ElevatorSystem
- ElevatorCar
- ElevatorController
- Floor
- Button- InternalButton, ExternalButton
- Direction- UP, DOWN, NONE
- Display
- Door
- Dispatcher- InternalDispatcher, ExternalDispatcher
- ElevatorSelectionStrategy- OddEvenStrategy, ZoneStrategy
- ElevatorControlStrategy- FirstComeFirstServe, ShortestSeekTime, ScanAlgorithm, LookAlgorithm