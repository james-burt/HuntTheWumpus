# HuntTheWumpus
A backend for a simple game.

## Project details
This project is set up to use TDD, with Mockito for mocking and piTest for mutation testing. At present there is 
no usable front end for the game. To run pitest use

    gradle pitest

Pitest reports are written to

    build/reports/pitest/index.html

The report shows both line coverage and any mutants that need to be suppressed through better tests.