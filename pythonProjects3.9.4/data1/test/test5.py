import numpy as np

import pandas as pd

df1 = pd.DataFrame({' ': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
                    '年级': ['大一', '大二', '大三', '大四', '大二', '大一', '大四', '大一', '大二', '大四', '大三', '大一'],
                    '姓名': ['马金花', '李昌贵', '王建国', '黎锦熙', '繁茂森', '张善民', '廖云龙', '刘盛喜', '马明全', '李意', '刘六一', '陈超'],
                    '年龄': [18, 19, 20, 21, 19, 18, 21, 18, 19, 22, 21, 19],
                    '性别': ['女', '男', '男', '女', '男', '男', '男', '女', '男', '女', '女', '男'],
                    '身高': [160, 168, 175, 166, 172, 180, 178, 158, 167, 165, 170, 185],
                    '体重': [48, 68, 72, 53, 75, 65, 80, 46, 64, 56, 60, 78]})
