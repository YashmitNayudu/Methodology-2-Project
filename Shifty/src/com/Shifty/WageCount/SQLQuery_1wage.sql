--Methodology of Programming 2 project
--author: Madison Buse Lewis
--project name: Shifty
--In this sql file the amount of hours a user is in the website will be calculated 
--and the result will be the amount of wage that specific user is going to get 
-- at the end of the day.

--creating table officer_timelogs for keeping the amount of time they are in Shifty.
create table officer_timelogs(
    employee_id int primary key not null,
    record_time DATETIME not null,
    day nvarchar(50) not null,
    type NUMERIC(18,0) not null
)

--creating table officer_rate to keep the amount of salary they made in hours.

create table officer_rate(
    employee_id int primary key REFERENCES officer_timelogs(employee_id),
    job_position NVARCHAR(50) not null,
    salary_per_hour NUMERIC not null
)

--inserting values into the tables we have created
INSERT into officer_timelogs
values('125', '2020-01-27 18:02:31.000', 'Wednesday', '1')

INSERT into officer_timelogs 
values ('125', '2020-01-27 7:54:03.000', 'Wednesday', '0')

INSERT into officer_rate
values('125', 'programmer', '100')

-- Now we calculate the amount of wage each employee is going to get.

select
    t.employee_id, 
    [Date], DATENAME(WEEKDAY, date)as [Day], 
    [Hours] = right(concat('00', diff / 3600), 2) + ' : ' + right(concat('00', diff % 3600 / 60), 2) + ' : ' + right(concat('00', diff % 60), 2),
    CAST(
    CASE WHEN diff <= 3600 * 8
        THEN diff * r.salary_per_hour / 3600
        ELSE 
            (3600 * 8 * r.salary_per_hour / 3600) -- salary x 8h / work
            + (diff - (3600 * 8)) * r.salary_per_hour * 0.2 /3600 -- OT work
        END AS decimal(10, 2)) AS Salary
from (
    select
        employee_id, 
        [date] = cast(record_time as date),
        diff = datediff(ss, min(iif(type = 0, record_time, null)), max(iif(type = 1, record_time, null)))
    from
        officer_timelogs
    where employee_id = '125'
    group by employee_id, cast(record_time as date)
) t
INNER JOIN officer_rate r ON t.employee_id = r.employee_id
order by date desc;