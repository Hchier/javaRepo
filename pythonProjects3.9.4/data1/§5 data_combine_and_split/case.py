import pandas as pd
import numpy as np

data = pd.read_excel('E:\Hchier\A\华清远见\data\player.xlsx')
print(dict(item for item in data.groupby('sex'))['男'].mean()['age'])
print(max(dict(item for item in data.groupby('sex'))['男']['height']))

data_male = dict(item for item in data.groupby('sex'))['男']
data_male['BMI'] = 0

print(data_male)


# # data_male.reindex(np.arange(0,len(data_male)))
#
# def outer(all_bmi):
#     weight = data_male['weight']
#     height = data_male['height']
#     return weight / ((height / 100) ** 2)
#
#
# all_bmi = data_male['BMI']
# data_male['BMI'] = data_male[['BMI']].apply(outer(all_bmi))
# print(data_male)
