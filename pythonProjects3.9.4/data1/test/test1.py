import numpy as np

list1 = np.random.normal(loc=0.0, scale=1.0, size=(1, 1000000))
list2 = []
# print(list1)
j = 0
sum = 0
for i in range(0, 1000000):
    sum += list1[0][i]
    list2.append(list1[0][i])

mean_value = sum / 1000000
std_value = np.array(list2).std()

for i in range(0, 1000000):
    if mean_value + 3 * std_value > list1[0][i] > mean_value - 3 * std_value:
        j += 1
print(j / 1000000)
