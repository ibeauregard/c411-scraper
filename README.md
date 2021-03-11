# C411 Scraper

## Overview
Given a CSV database of personal information records, this application updates the database by appending the correct phone number to each record. It does that by scraping the [canada411.ca](https://www.canada411.ca/) website.

## Database format
The input database is placed at `src/main/resources/database.csv`. See the current file for the expected format.

## Output database
After running the application, the output database will be found at `target/classes/database_out.csv`.
