import numpy as np

# 矩阵乘积 dot(), matmul
# 5x2 成绩表
grade1 = np.array([[70, 65], [40, 80], [70, 20], [40, 10], [90, 100]])
factor_grade_array = np.array([[0.3], [0.7]])
print(np.dot(grade1, factor_grade_array))
print(np.matmul(grade1, factor_grade_array))
