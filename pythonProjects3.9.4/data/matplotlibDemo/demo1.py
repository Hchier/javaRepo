import matplotlib.pyplot as plt
import numpy as np

# # 折线图 1，准备数据 2，创建画布 3，绘制特定类型的图形 4，绘制图表的其他组件 5，显示图形
# list1 = np.arange(20)
# print(list1)
# # 画布
# plt.figure(figsize=(30, 30), dpi=100, edgecolor='red')
# # 绘制折线图
# plt.plot(list1, -list1)
# plt.show()


# # 柱状图
# list1 = np.arange(10)
# plt.bar(list1, list1)  # barh()水平柱状图
# plt.figure(figsize=(30, 30), dpi=100)
# plt.title("top5 movie")
# plt.ylabel("票房")
# plt.show()

# # 直方图
# # 散点图
# # 饼图
# # 创建并配置画布
# figure = plt.figure(figsize=(10, 6), dpi=100)
# # plt.pie(数据集,标签)
# movies = [1, 2, 3]
# plt.pie(movies)
# plt.show()

# # 散点图
# scatter_x = np.random.rand(1000)
# scatter_y = np.random.rand(1000)
# #
# figure = plt.figure(figsize=(10, 6), dpi=100)
# plt.scatter(scatter_x, scatter_y)
# plt.show()


# # 直方图
# datas = np.random.normal(0, 1, 100000)
# bins = 180   # 区间个数，越大，越圆滑
# figure = plt.figure(figsize=(10, 6), dpi=100)
# plt.hist(datas, bins)
# plt.show()


# 箱型图
# 100行5列随机数
ndarray2 = np.random.uniform(1, 10, 500).reshape(100, 5)

figure = plt.figure(figsize=(10, 6), dpi=100)
plt.boxplot(ndarray2)
plt.show()
