import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

path = open('E:\Hchier\A\华清远见\data\IMDB-Movie-Data.csv', encoding='UTF-8')
data = pd.read_csv(path)
Rating = data['Rating']
Runtime = data['Runtime (Minutes)']

# plt.hist(Rating, bins=30, color='g', alpha=0.7)
plt.hist(Runtime, bins=30, color='g', alpha=0.7)
plt.show()
