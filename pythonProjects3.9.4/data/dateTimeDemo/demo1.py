import pandas as pd
from datetime import datetime
from datetime import timedelta

# # 生成python原生库中日期对象创建方式
# # 时间对象
# datetime1 = datetime(2001, 9, 28)
# # 偏移量
# timedelta1 = timedelta(days=1)
# print(datetime1 + timedelta1)
#
# # 传入一个日期格式的字符串列表，得到一个时间库序列DatatimeIndex， dtype=datetime64
# datetimeIndex1 = pd.to_datetime(["2012-1-1", "2013-10-1", "2022-1-8"])
# print(datetimeIndex1)
# # 使用时间序列索引
# print(pd.Series([1, 2, 3], index=datetimeIndex1))


# 生成时间序列 从某日到某日
# start生成的时间序列的七点    end终点    period生成的时间序列的个数      freq频率，时间的间隔默认值为1天  D day, H hour
print(pd.date_range(start="2001-09-28", end="2021-5-15", freq='2D'))
