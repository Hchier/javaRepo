import pandas as pd
import numpy as np
from sqlalchemy import create_engine

# csv
# excel
# 读excel
data = pd.read_excel('E:\Hchier\A\华清远见\data\employee.xlsx')
print(data)
# data.to_csv('E:\Hchier\A\华清远见\data\employee.csv')


# 数据库
# engine = create_engine('mysql+mysqlconnector://root:pyh903903@localhost/test')
# sql = 'select * from employee'
# # 读数据库
# print(pd.read_sql(sql, engine))
# # 写入数据库
# print(pd.DataFrame(np.arange(12).reshape(3, 4)).to_sql('test', engine, if_exists='append',))
