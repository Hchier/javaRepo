import numpy as np

# 生成ndarray array,arange,zero,ones,empty

# np.random.seed(0)，每次生成相同的随机数


# # 生成随机20个[0, 1)间的随机数
# print(np.random.rand(10))
# # 20个[0, 10)的整数
# print(np.random.randint(0, 10, 20))
# # 20个[0, 1)中符合平均分布的随机数
# print(np.random.uniform(0, 1, 20))
# # 正态分布
# a10 = np.random.normal(0, 25, 50)
# print(a10[a10 > 5])
#
# print()
# # print(help(np.random.randint))

# 酒鬼漫步，随机向前向后，走2000步
a10 = np.random.rand(2000)
a11 = np.where(a10 >= 0.5, 1, -1)
sum = 0
sum_list = []
for i in range(0, len(a11)):
    sum += a11[i]
    sum_list.append(sum)

# 前n项累加的值的数组，相当于上面的for循环
random_distance = np.cumsum(a11)
print("max:", np.max(random_distance))
print("min:", np.min(random_distance))
print("max:", max(sum_list))
print("min:", min(sum_list))

# 最先走到正15m的位置
print(random_distance > 15)
print(np.argmax(random_distance >= 15))
print(np.argmax(random_distance <= -15))


