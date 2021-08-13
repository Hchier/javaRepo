import pandas as pd
from sqlalchemy import create_engine
import mysql

# df1 = pd.read_excel(r'E:\Hchier\A\华清远见实训日志\data\department.xlsx')
# 数据库+数据库驱动://登录名:密码@主机地址:端口号/数据库名
conn = create_engine('mysql+mysqlconnector://root:pyh903903@127.0.0.1:3306/testdb')
# 打印表
print(pd.read_sql_table('employee', conn))
print()
# 执行sql查询
print(pd.read_sql_query("select * from employee where FIRST_NAME='裴'", conn))

