--练习题https://www.nowcoder.com/ta/sql
--函数大全http://c.biancheng.net/mysql/function/
第一遍没写出来的：1、2、12、14、15、17、18（重要）、21（重要）、23（重要）、25（重要）、

1.查找最晚入职员工的所有信息
select * from employees where hire_date = (select max(hire_date) from employees)
--难点在于最晚入职的员工可能不止一个，所以不能使用limit,故用max
自己想的：
select * from employees order by hire_date desc limit (select count(*) from employees group by hire_date order by hire_date desc limit 1)

2.查找入职员工时间排名倒数第三的员工所有信息
select * from employees where hire_date = (select distinct hire_date from employees order by hire_date desc limit 2,1)
--难点：distinct用法和limit的另一种用法

4.查找所有已经分配部门的员工的last_name和first_name以及dept_no(请注意输出描述里各个列的前后顺序)
select em.last_name,em.first_name,de.dept_no from employees em inner join dept_emp de on em.emp_no = de.emp_no
--难点：审题，是所有已分配部门的员工，而不是所有员工

7.查找薪水变动超过1次的员工号emp_no以及其对应的变动次数t
select emp_no, count(emp_no) t from salaries group by emp_no having count(emp_no) > 1
--难点：having用法

12.获取所有部门中当前(dept_emp.to_date = '9999-01-01')员工当前(salaries.to_date='9999-01-01')薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary
select e.dept_no,e.emp_no,MAX(s.salary) from dept_emp e inner join salaries s on e.emp_no = s.emp_no where s.to_date='9999-01-01' and e.to_date = '9999-01-01' GROUP BY e.dept_no
--难点1：使用聚合函数为什么分组是这样的
--解答：在牛客编译没问题，在本地mysql跑时，需要把e.dept_no,e.emp_no分组都加上

14.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。注意对于重复的emp_no进行忽略(即emp_no重复的title不计算，title对应的数目t不增加)。
select title, count(distinct emp_no)  t from titles group by title having t >= 2
--难点：count,distinct,having的混合用法

15.查找employees表所有emp_no为奇数，且last_name不为Mary(注意大小写)的员工信息
select * from employees where  mod(emp_no,2)=1 and last_name!='Mary'    --也可以用emp_no%2=1
--难点：convert(NUMERIC(10,2),def1),round(88.123,2),mod(12,5)等数值型函数使用

17.获取当前（to_date='9999-01-01'）薪水第二多的员工的emp_no以及其对应的薪水salary
select emp_no,salary from salaries where to_date='9999-01-01' and salary = (select distinct(salary) from salaries order by salary desc limit 1,1)
--难点：去重用法

18.查找当前薪水排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，你可以不使用order by完成吗
--某个牛逼的答案如下：
select e.emp_no,s.salary,e.last_name,e.first_name from employees e join salaries s on e.emp_no=s.emp_no and s.salary = 
(select s1.salary from salaries s1 join salaries s2 on s1.salary <= s2.salary group by s1.salary having count(distinct s2.salary) = 2)
--自己写的如下：
select em.emp_no,sa.salary,em.last_name,em.first_name from employees em join salaries sa on em.emp_no = sa.emp_no where sa.salary = 
(select max(salary) from salaries where salary <> (select max(salary) from salaries)) 
--难点：那个牛逼的答案，最后的count我没看明白

21.查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序
select em.emp_no,(sa1.salary-sa2.salary) growth from employees em 
inner join salaries sa1 on em.emp_no = sa1.emp_no
inner join salaries sa2 on em.emp_no = sa2.emp_no
and sa2.from_date = em.hire_date order by growth asc
--难点：自己join自己，并且没有理解sa2才是涨薪前的薪资表，所以命名要规范，建议命名sa1=sa_to,sa2=sa_from

23.对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
select emp_no,salary ,(select count(distinct salary) from salaries s2 where s1.salary<=s2.salary) as rank from salaries s1 order by s1.salary desc,s1.emp_no asc;
--难点：官方答案在mysql执行不了

25.获取员工其当前的薪水比其manager当前薪水还高的相关信息，给出员工的emp_no，manager_no，员工当前的薪水emp_salary,manager当前的薪水manager_salary
select em.emp_no,ma.emp_no,sa1.salary emp_salary,sa2.salary manager_salary
from dept_emp em inner join dept_manager ma on em.dept_no = ma.dept_no
inner join salaries sa1 on em.emp_no = sa1.emp_no
inner join salaries sa2 on ma.emp_no = sa2.emp_no
where sa1.salary > sa2.salary
--难点：自己join自己，自己写出来了感觉老牛逼了







































