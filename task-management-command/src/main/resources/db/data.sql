insert into employees (id, first_name, last_name, role, supervisor_id)
values (1, 'Alice', 'Smith', 'SUPERVISOR', null),
       (2, 'Bob', 'Jones', 'Developer', 1),
       (3, 'Charlie', 'Brown', 'PEASANT', 1),
       (4, 'David', 'Green', 'PEASANT', 1),
       (5, 'Eve', 'White', 'PEASANT', 1);
insert into tasks (id, comment, completion_date, due_date, name, status)
values (1, 'Create a new feature', null, '2023-05-01', 'Feature A', 'PUBLISHED'),
       (2, 'Fix a bug', null, '2023-04-30', 'Bug B', 'PUBLISHED'),
       (3, 'Write a test case', null, '2023-04-29', 'Test C', 'PUBLISHED'),
       (4, 'Implement a design', null, '2023-05-02', 'Design D', 'PUBLISHED'),
       (5, 'Review a code', '2023-04-28', '2023-04-28', 'Code E', 'COMPLETED'),
       (6, 'Update a document', null, '2023-05-03', 'Document F', 'PUBLISHED'),
       (7, 'Conduct a user research', null, '2023-05-04', 'Research G', 'PUBLISHED'),
       (8, 'Create a prototype', null, '2023-05-05', 'Prototype H', 'PUBLISHED'),
       (9, 'Write a report', null, '2023-05-06', 'Report I', 'CANCELLED'),
       (10, 'Analyze data', null, '2023-05-07', 'Data J', 'CANCELLED'),
       (11, 'Make a presentation', null, '2023-05-08', 'Presentation K', 'PUBLISHED'),
       (12, 'Plan a project', null, '2023-05-09', 'Project L', 'PUBLISHED');
