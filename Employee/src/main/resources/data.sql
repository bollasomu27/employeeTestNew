INSERT INTO Department(DEPART_CODE) VALUES
('D101'), ('D102'), ('D103'), ('D104'), ('D105');

INSERT INTO Project(PROJECT_CODE, DEPART_ID) VALUES
('P1001', 1), ('P1002', 1), ('P1003', 2), ('P1004', 2),
('P1005', 3), ('P1006', 3), ('P1007', 4), ('P1008', 4),
('P1009', 5), ('P1010', 5);

INSERT INTO Employee (EMP_CODE, NAME, CITY, DEPARTMENT_ID, PROJECT_ID) VALUES
  ('E10001', 'somu', 'bangalore', 1 , 1),
  ('E10001', 'somu', 'bangalore', 1 , 2),
  ('E10002', 'ramu', 'delhi', 2 , 3),
  ('E10002', 'ramu', 'delhi', 2 , 4),
  ('E10003', 'prem', 'hyderabad', 2 , 3),
  ('E10004', 'gopi', 'chennai', 3 , 6),
  ('E10005', 'roy', 'pune', 4 , 8),
  ('E10006', 'abhi', 'hyderabad', 2 , 3),
  ('E10007', 'ravi', 'hyderabad', 1 , 1),
  ('E10008', 'leela', 'mumbai', 5 , 10),
  ('E10009', 'madhu', 'noida', 5 , 9),
  ('E10010', 'malli', 'hyderabad', 4 , 7),
  ('E10010', 'malli', 'hyderabad', 4 , 8),
  ('E10011', 'nag', 'hyderabad', 3, 6);

