import pandas as pd

# series1 = pd.Series['1', 23, None, 33, '']
# isnull_bool = pd.notnull(series1)
# print(isnull_bool)

# df1 = pd.read_excel()
# excel某列空值换成value df1[列名].fillna(value='value',inplace=True)
#

df2 = pd.read_excel(r'E:\Hchier\A\华清远见实训日志\data\department.xlsx')
print(df2)
df2.duplicated()
