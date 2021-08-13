import pandas as pd
import numpy as np

# df1 = pd.DataFrame({"key": ["a", "a", "c", "d"], "": [1, 2, 3, 4]})
# groupby1 = df1.groupby(by="key")
# # 每个item为一个元组，元组的第一个对象为分组的名称.第二个为分组对象
# for item in groupby1:
#     print(item)
# print()
# for x, y in groupby1:
#     print("分组名称", x)
#     print("分组对象", y)
# print()

# 可以使用列表推导式快捷的拿取某个分组的具体数据
# 字典可以从全局内置函数dict（元组列表） 元组要求2个元素，第一个元素当作key，第二个当作value
# tuple1_list = [("key1", 1), ("key2", 2), ("key3", 3)]
# dict1 = dict(tuple1_list)
# print(dict1["key1"])

# df2 = pd.DataFrame({"key": ["a", "a", "c", "d"], "": [1, 2, 3, 4]})
# groupby2 = df2.groupby(by="key")
# groupby_list = [(x, y) for x, y in groupby2]
#
# print(dict(groupby_list))
# # 通过字典查询key，就可以快捷的拿到每个分组的记录集
# print(dict(groupby_list)["a"])


# 聚合
# count()统计不为NaN的记录个数
# max min mean平均 std 标准差
df3 = pd.DataFrame({"key": ["a", "a", "c", "c", "d", "d", "d"], "salary": [1, 2, 3, 3, 4, 3, 4], "job": [11, 11, 33, 44, 22, 22, 33]})
#df3=pd.read_excel("E:\Hchier\A\华清远见\data\employee.xlsx")
print(df3)
groupby2 = df3.groupby(by="job")
print("groupby2.count():", groupby2.count())
# 各个聚集函数
print(groupby2.describe())
# 各个聚集的最大值
print(groupby2.agg("max"))

