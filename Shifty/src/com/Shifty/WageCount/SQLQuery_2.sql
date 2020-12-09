select
    t.employee_id, 
    [Date], DATENAME(WEEKDAY, date)as [Day], 
    [Hours] = right(concat('00', diff / 3600), 2) + ' : ' + right(concat('00', diff % 3600 / 60), 2) + ' : ' + right(concat('00', diff % 60), 2),
	CAST(
	CASE WHEN diff <= 3600 * 8
		THEN diff * r.salary / 3600
		ELSE 
			(3600 * 8 * r.salary / 3600) -- salary x 8h / work
			+ (diff - (3600 * 8)) * r.salary * 0.2 /3600 -- OT work
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
order by date desc