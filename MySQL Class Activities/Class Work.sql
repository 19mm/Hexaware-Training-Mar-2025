SELECT e_name, sal FROM emp ORDER BY sal DESC LIMIT 3;

SELECT e1.e_name AS employee, e2.e_name AS manager, e1.sal 
FROM emp e1 
JOIN emp e2 ON e1.mgr = e2.emp_no 
WHERE e1.sal = e2.sal;

SELECT d.d_name, SUM(e.sal) AS total_salary_expense 
FROM emp e 
JOIN dept d ON e.DEPT_NO = d.DEPT_ID 
GROUP BY d.d_name 
ORDER BY total_salary_expense DESC 
LIMIT 1;