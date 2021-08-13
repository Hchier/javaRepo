import pandas as pd
import numpy as np

dict1 = {'name': ['张三', '李四', '王五'], 'age': [12, 34, 12], 'sex': ['m', 'f', 'm']}
#
# print(pd.DataFrame(dict1))
# print()
# # 基本索引方式
# # 第一列
# print(pd.DataFrame(dict1)['name'])
# # 前两行
# print(pd.DataFrame(dict1)[:2])
# # 0行及后面的
# print(pd.DataFrame(dict1)[0:])
# #   .loc[行序号][列序号]
# print(pd.DataFrame(dict1).loc[0, 'name'])

# # 拿到两列
# print(pd.DataFrame(dict1)[['name', 'age']])

# #  切片  loc[:,:]
# # 前两行和前两列
# print(pd.DataFrame(dict1).loc[:1, 'name':'age'])
# # 后两行后两列
# print(pd.DataFrame(dict1).loc[1:, 'age':'sex'])
# # 第一行第二行age列、sex列
# print(pd.DataFrame(dict1).loc[1:2, 'age':'sex'])

# # age>20的
# bool_series = pd.DataFrame(dict1)['age'] > 20
# print(pd.DataFrame(dict1)[bool_series])

# # 缺的用NaN填充
# # series1相应位置加series2
# series1 = pd.Series(range(10))
# # series2 = pd.Series(range(11))
# # print(series1 + series2)
# # print(series1.add(series2))
# #
# # # 按照索引排序
# # print(series1.sort_index(ascending=False))
# # # 按照值排
# # print(series1.sort_values(ascending=False))
# # # 将dataframe按照索引倒着排
# # print(pd.DataFrame(dict1).sort_index(ascending=False))
# # # 将dataframe按照age列的值倒着排
# # print(pd.DataFrame(dict1).sort_values(by='age', ascending=False))



# describe
# count()不为NaN的个数
# mean平均值
# std标准差
# min最小
# sum求和
# cumsum累计和
# print(pd.DataFrame(dict1).describe)