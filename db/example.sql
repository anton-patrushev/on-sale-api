-- simples likes join
SELECT likes.id as id, offers FROM (likes LEFT JOIN offers on offers.id = likes.offer_id) LEFT JOIN employees on employees.id = likes.employee_id;

-- likes complex joins
SELECT likes.id, companies.name, employees.first_name, employees.last_name
FROM
     likes
         LEFT JOIN (offers LEFT JOIN companies on offers.company_id = companies.id)
     on likes.offer_id = offers.id
    LEFT JOIN employees on likes.employee_id = employees.id
;