-- Methodology of Programming 2 project
-- Author: Madison Buse Lewis
-- Project name: Shifty
-- In this SQL file the two tables, oficer_timelogs and officer_rate, will be 
-- created. Then the emloyees that have registered and logged out of Shifty are  
-- then listed so that the other SQL Query, SQLQUERY_2, will calculate the wages
-- given in this query.

--creating the table officer_timelogs for keeping the amount of time they are in Shifty. 
CREATE TABLE officer_timelogs (employee_id  INT, record_time DATETIME, [day] VARCHAR(20), [type] BIT);
INSERT INTO officer_timelogs VALUES (125, '2018-03-02 18:00:00.000', 'Friday', 1), (125, '2018-03-02 09:00:00', 'Friday', 0)
INSERT INTO officer_timelogs VALUES (125, '2018-03-01 19:10:49.000', 'Thursday', 1), (125, '2018-03-01 09:00:00', 'Thursday', 0)
INSERT INTO officer_timelogs VALUES (125, '2018-02-28 19:14:11.000', 'Wednesday', 1), (125, '2018-02-28 09:00:00', 'Wednesday', 0)
INSERT INTO officer_timelogs VALUES (125, '2018-02-27 18:03:31.000', 'Tuesday', 1), (125, '2018-02-27 07:54:03.000', 'Tuesday', 0)
INSERT INTO officer_timelogs VALUES (125, '2018-02-26 19:13:34.000', 'Monday', 1), (125, '2018-02-26 09:00:00', 'Monday', 0)
INSERT INTO officer_timelogs VALUES (125, '2018-02-21 10:00:00.000', 'Monday', 1), (125, '2018-02-21 09:00:00', 'Monday', 0)

-- creating table officer_rate to keep the amount of salary they made in hours.
CREATE TABLE officer_rate (employee_id  INT, designation VARCHAR(20), salary INT);
INSERT INTO officer_rate VALUES (125, 'programmer', 100);
