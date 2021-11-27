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

-- select with many-to-many relation
SELECT offers.sale, companies.name, category_id
FROM
    offers_categories
    LEFT JOIN (offers LEFT JOIN companies on companies.id = offers.company_id)
        on offers_categories.offer_id = offers.id
    LEFT JOIN categories on offers_categories.category_id = categories.id
GROUP BY offers.sale, companies.name, category_id
;

-- select offers by category
SELECT categories.name as category_name, companies.name as company_name, offers.description
FROM
    offers_categories
    LEFT JOIN categories on categories.id = offers_categories.category_id
    LEFT JOIN offers on offers.id = offers_categories.offer_id
    LEFT JOIN companies on companies.id = offers.company_id
WHERE offers_categories.category_id = 'a4eebc99-9c0b-4ef8-bb6d-6bb9bd380a12'
GROUP BY categories.name, companies.name, offers.description
;

-- select category for offer
SELECT categories.name as category_name, companies.name as company_name, offers.description
FROM
    offers_categories
    LEFT JOIN offers on offers.id = offers_categories.offer_id
    LEFT JOIN companies on companies.id = offers.company_id
    LEFT JOIN categories on categories.id = offers_categories.category_id
WHERE offers_categories.offer_id = 'a2eebc99-9c0b-4ef8-bb6d-6bb9bd380a14'
GROUP BY categories.name, companies.name, offers.description
;